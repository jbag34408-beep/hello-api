package com.example.hello_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Memo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  public Memo() {}

  public Memo(Long id, String content) {
    this.id = id;
    this.content = content;
  }

  public Long getId() { return id; }
  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }
  public Category getCategory() { return category; }
  public void setCategory(Category category) { this.category = category; }
}