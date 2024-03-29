package com.upskilled.taskjwt.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (request.getServletPath().equals("/v2/auth/login")
				|| request.getServletPath().equals("/v2/auth/token/refresh")
				|| request.getServletPath().equals("/v2/auth/info")) {

			filterChain.doFilter(request, response);

		} else {

			String authorizationHeader = request.getHeader("Authorization");

			if (Optional.ofNullable(authorizationHeader).isPresent() && authorizationHeader.startsWith("Bearer ")) {

				try {

					String token = authorizationHeader.substring("Bearer ".length());

					Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

					JWTVerifier verifier = JWT.require(algorithm).build();

					DecodedJWT decodedJWT = verifier.verify(token);

					String username = decodedJWT.getSubject();

					String[] roles = decodedJWT.getClaim("roles").asArray(String.class);

					Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

					Arrays.asList(roles).forEach(role -> {
						authorities.add(new SimpleGrantedAuthority(role));
					});

					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							username, null, authorities);

					SecurityContextHolder.getContext().setAuthentication(authenticationToken);

					filterChain.doFilter(request, response);

				} catch (Exception e) {

					log.error("Error logging in {}", e.getMessage());

					Map<String, Object> error = new HashMap<String, Object>();

					response.setHeader("error", e.getMessage());
					response.setStatus(HttpStatus.FORBIDDEN.value());
					response.setContentType(MediaType.APPLICATION_JSON_VALUE);

					error.put("error", e.getMessage());
					error.put("status", HttpStatus.FORBIDDEN.value());

					new ObjectMapper().writeValue(response.getOutputStream(), error);
				}

			} else {

				filterChain.doFilter(request, response);

			}
		}
	}
}
