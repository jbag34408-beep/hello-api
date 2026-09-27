package com.example.hello_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
  private final MemoService memoService;
  public HelloController(MemoService memoService) {
    this.memoService = memoService;
  }

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
  @GetMapping("/memos")
  public List<Memo> getMemos() {
    return memoService.findAll();
  }
  @PostMapping("/memos")
  public Memo addMemo(@RequestBody Memo memo) {
    return memoService.add(memo.getContent());
  }
  @GetMapping("/memos/{id}")
  public Memo getMemo(@PathVariable long id) {
    return memoService.findById(id);
  }
  @DeleteMapping("/memos/{id}")
  public void deleteMemo(@PathVariable long id) {
    memoService.deleteById(id);
  }
}


