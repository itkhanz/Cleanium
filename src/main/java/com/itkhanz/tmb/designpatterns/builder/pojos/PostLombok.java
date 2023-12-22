package com.itkhanz.tmb.designpatterns.builder.pojos;

import com.itkhanz.tmb.designpatterns.builder.interfaces.IPost;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder(setterPrefix = "set")
public class PostLombok implements IPost {
  private String title;
  private String body;
  private int userId;
}
