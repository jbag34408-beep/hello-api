package com.example.hello_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class HelloController {

  private final MemoService memoService;
  private final CategoryRepository categoryRepository;

  public HelloController(MemoService memoService, CategoryRepository categoryRepository) {
    this.memoService = memoService;
    this.categoryRepository = categoryRepository;
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
    return new Memo(1L, "첫 메모");
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

  @PutMapping("/memos/{id}")
  public Memo updateMemo(@PathVariable long id, @RequestBody Memo memo) {
    return memoService.update(id, memo.getContent());
  }

  @DeleteMapping("/memos/{id}")
  public void deleteMemo(@PathVariable long id) {
    memoService.deleteById(id);
  }

  @GetMapping("/memos/search")
  public List<Memo> searchMemos(@RequestParam String keyword) {
    return memoService.search(keyword);
  }

  @PostMapping("/categories")
  public Category addCategory(@RequestBody Category category) {
    return categoryRepository.save(category);
  }

  @GetMapping("/categories")
  public List<Category> getCategories() {
    return categoryRepository.findAll();
  }

  @PutMapping("/memos/{memoId}/category/{categoryId}")
  public Memo assignCategory(@PathVariable long memoId, @PathVariable long categoryId) {
    Category category = categoryRepository.findById(categoryId)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "카테고리를 찾을 수 없습니다. id=" + categoryId));
    return memoService.assignCategory(memoId, category);
  }
}