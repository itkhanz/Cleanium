package com.itkhanz.tests.builder;

import com.itkhanz.tmb.designpatterns.builder.interfaces.IPost;
import com.itkhanz.tmb.designpatterns.builder.pojos.Post;
import com.itkhanz.tmb.designpatterns.builder.pojos.PostBuilder;
import com.itkhanz.tmb.designpatterns.builder.pojos.PostLombok;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePostTest {

  @Test
  public void test_create_post() {

    //IPost post = createPostUsingConventionalApproach();
    //IPost post = createPostUsingExternalBuilderClass();
    //IPost post = createPostUsingStaticNestedInnerClass();
    IPost post = createPostUsingLombok();

    Response response = makePostApiRequest(post);

    Assert.assertEquals(response.getStatusCode(), 201);
  }


  private Post createPostUsingConventionalApproach() {
    //Approach 01 - conventional approach
    // Problem here is if the number of parameters are more, and some parameters are optional,
    // then we have to create lots of different constructors using method overloading which is not ideal approach
    return new Post("foo", "bar", 123);
  }

  private Post createPostUsingExternalBuilderClass() {
    //Approach 02 - Using External Builder class
    return  PostBuilder.builder()
      .setTitle("foo")
      .setBody("bar")
      .setUserId(123)
      .build()
      ;
  }

  private Post createPostUsingStaticNestedInnerClass() {
    //Approach 03 - Using Static Inner Class
    return Post.builder().setTitle("foo").setBody("bar").setUserId(123).build();
  }

  private PostLombok createPostUsingLombok() {
    //Approach 04 - Using Lombok Builder
    return PostLombok.builder().setTitle("foo").setBody("bar").setUserId(123).build();
  }

  private Response makePostApiRequest(IPost post) {
      return given()
              .baseUri("https://jsonplaceholder.typicode.com/")
              .log().all()
              .contentType(ContentType.JSON)
              .body(post)
            .when()
              .post("/posts")
            .then()
              .log().all()
              .extract().response()
        ;
  }
}
