package com.example.hello_api;

import org.springframework.stereotype.Service;
import java.util.*;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class MemoService {
  private final List<Memo> memos =  new ArrayList<>();
  private final AtomicLong idCounter = new AtomicLong(1);
  public List<Memo> findAll() {
    return memos;
  }
  public Memo add(String content) {
    Memo memo = new Memo(idCounter.getAndIncrement(),content);
    memos.add(memo);
    return memo;
  }
  public Memo findById(Long id) {
    return memos.stream()
        .filter((m -> m.getId().equals(id)))
        .findFirst()
        .orElse(null);
  }
  public void deleteById(Long id) {
    memos.removeIf(memo -> memo.getId().equals(id));
  }
}
