package org.ujar.bs.rst.helloworld.web.dto;

public record GreetingDto() {
  private static final String MESSAGE = "Hello, World!";
  
  public String getMessage() {
    return MESSAGE;
  }
}
