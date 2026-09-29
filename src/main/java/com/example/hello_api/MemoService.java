package com.example.hello_api;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    return memoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "메모를 찾을 수 없습니다. id=" + id));
  }

  public Memo update(Long id, String content) {
    Memo memo = findById(id);
    memo.setContent(content);
    return memoRepository.save(memo);
  }

  public void deleteById(Long id) {
    if (!memoRepository.existsById(id)) {
      throw new ResponseStatusException(
              HttpStatus.NOT_FOUND, "메모를 찾을 수 없습니다. id=" + id);
    }
    memoRepository.deleteById(id);
  }

  public List<Memo> search(String keyword) {
    return memoRepository.findByContentContaining(keyword);
  }
  public Memo assignCategory(Long id, Category category) {
    Memo memo = findById(id);
    memo.setCategory(category);
    return memoRepository.save(memo);
  }
}