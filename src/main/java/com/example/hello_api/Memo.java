package com.example.hello_api;

public class Memo {
  public Memo() {}
  private Long id;
  private String content;

  public Memo(Long id, String content) {
    this.id = id;
    this.content = content;
  }
  public Long getId()
    {return id;}
  public String getContent()
    {return content;}
  public  void setContent(String content)
    {this.content = content;}
}
