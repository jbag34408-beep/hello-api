package com.example.hello_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "Hello Spring Boot!";
  }


  @GetMapping("/hello/{name}")
  public String helloName(@PathVariable String name) {
    return "Hello " + name + "님!";
  }

  @GetMapping("/greet")
  public String greet(@RequestParam String name) {
    return name + "님 , 환영합니다";
  }
  @GetMapping("/memo")
  public Memo getMemo() {
    return new Memo(1l, "첫 메모");
  }
}


