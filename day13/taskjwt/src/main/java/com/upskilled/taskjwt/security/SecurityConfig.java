package com.upskilled.taskjwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.upskilled.taskjwt.filter.CustomAuthenticationFilter;
import com.upskilled.taskjwt.filter.CustomAuthorizationFilter;

import lombok.SneakyThrows;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService UserDetailsService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(UserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());

		customAuthenticationFilter.setFilterProcessesUrl("/v2/auth/login");

		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/v2/auth/login/**", "/v2/auth/info/**", "/v2/auth/token/refresh/**")
				.permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/v2/api/user/**").hasAnyAuthority("ROLE_USER",
				"ROLE_MANAGER", "ROLE_ADMIN", "ROLE_SUPER_ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/v2/api/user/save/**").hasAnyAuthority("ROLE_MANAGER",
				"ROLE_ADMIN", "ROLE_SUPER_ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/v2/api/role/**").hasAnyAuthority("ROLE_MANAGER",
				"ROLE_ADMIN", "ROLE_SUPER_ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/v2/api/users").hasAnyAuthority("ROLE_SUPER_ADMIN");
		http.authorizeRequests().anyRequest().fullyAuthenticated();
		http.addFilter(customAuthenticationFilter);
		http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	@SneakyThrows(Exception.class)
	public AuthenticationManager authenticationManagerBean() {

		return super.authenticationManagerBean();
	}
}
