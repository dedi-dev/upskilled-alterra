package com.upskilled.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upskilled.task.dto.CreateAuthorDto;
import com.upskilled.task.dto.DeleteAuthorDto;
import com.upskilled.task.dto.UpdateAuthorDto;
import com.upskilled.task.service.AuthorService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class AuthorController {
  @Autowired
  private AuthorService service;

  @SneakyThrows(Exception.class)
  @PostMapping(path = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> create(@RequestBody CreateAuthorDto dto) {
    log.info("/api/v1/author Create Executed");
    return service.create(dto);
  }

  @SneakyThrows(Exception.class)
  @GetMapping(path = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> get() {
    log.info("/api/v1/author Create Executed");
    return service.get();
  }

  @SneakyThrows(Exception.class)
  @PutMapping(path = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> update(@RequestBody UpdateAuthorDto dto) {
    log.info("/api/v1/author Update Executed");
    return service.update(dto);
  }

  @SneakyThrows(Exception.class)
  @DeleteMapping(path = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> delete(@RequestBody DeleteAuthorDto dto) {
    log.info("/api/v1/author Delete Executed");
    return service.delete(dto);
  }

}
