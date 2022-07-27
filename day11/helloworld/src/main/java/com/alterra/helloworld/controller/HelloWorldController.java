package com.alterra.helloworld.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/messages")
public class HelloWorldController {
  @GetMapping
  public String getHelloWorld() {
    return "Get Hello World";
  }

  @PostMapping
  public String postHelloWorld() {
    return "Post Hello World";
  }

  @DeleteMapping
  public String deleteHelloWorld() {
    return "Delete Hello World";
  }
}
