package com.example.hello_api;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemoService {

  private final MemoRepository memoRepository;

  public MemoService(MemoRepository memoRepository) {
    this.memoRepository = memoRepository;
  }

  public List<Memo> findAll() {
    return memoRepository.findAll();
  }

  public Memo add(String content) {
    Memo memo = new Memo();
    memo.setContent(content);
    return memoRepository.save(memo);
  }

  public Memo findById(Long id) {
    return memoRepository.findById(id).orElse(null);
  }

  public void deleteById(Long id) {
    memoRepository.deleteById(id);
  }
}