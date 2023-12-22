package com.itkhanz.tmb.designpatterns.builder.pojos;

public class PostBuilder {
  private String title;
  private String body;
  private int userId;

  private PostBuilder() {}

  public static PostBuilder builder() {
    return new PostBuilder();
  }

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
