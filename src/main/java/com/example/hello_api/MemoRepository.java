package com.example.hello_api;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo,Long> {
    List<Memo> findByContentContaining(String keyword);
}