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

import com.upskilled.task.dto.CreateBookDto;
import com.upskilled.task.dto.DeleteBookDto;
import com.upskilled.task.dto.UpdateBookDto;
import com.upskilled.task.service.BookService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class BookController {
  @Autowired
  BookService service;

  @SneakyThrows(Exception.class)
  @PostMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> create(@RequestBody CreateBookDto dto) {
    log.info("/api/v1/book Post is Executed");
    return service.create(dto);
  }

  @SneakyThrows(Exception.class)
  @GetMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getAll() {
    log.info("/api/v1/book Get is Executed");
    return service.getAll();
  }

  @SneakyThrows(Exception.class)
  @DeleteMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> delete(@RequestBody DeleteBookDto dto) {
    log.info("/api/v1/book Delete is Executed");
    return service.delete(dto);
  }

  @SneakyThrows(Exception.class)
  @PutMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> update(@RequestBody UpdateBookDto dto) {
    log.info("/api/v1/book Update is Executed");
    return service.update(dto);
  }
}
