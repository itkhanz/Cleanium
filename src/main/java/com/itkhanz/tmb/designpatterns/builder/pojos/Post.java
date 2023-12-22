package com.itkhanz.tmb.designpatterns.builder.pojos;

import com.itkhanz.tmb.designpatterns.builder.interfaces.IPost;

public class Post implements IPost {
  private String title;
  private String body;
  private int userId;

  public Post(String title, String body, int userId) {
    this.title = title;
    this.body = body;
    this.userId = userId;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public int getUserId() {
    return userId;
  }

  public static PostBuilder builder() {
    return new PostBuilder();
  }

  //static inner class
  public static class PostBuilder {
    private String title;
    private String body;
    private int userId;

    public Post build() {
      return new Post(title, body, userId);
    }

    public PostBuilder setTitle(String title) {
      this.title = title;
      return this;
    }

    public PostBuilder setBody(String body) {
      this.body = body;
      return this;
    }

    public PostBuilder setUserId(int userId) {
      this.userId = userId;
      return this;
    }


  }

}
