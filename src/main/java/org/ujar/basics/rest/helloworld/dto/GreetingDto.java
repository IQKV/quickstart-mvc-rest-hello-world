package org.ujar.basics.rest.helloworld.dto;

public record GreetingDto() {
  private static final String MESSAGE = "Hello, World!";
  
  public String getMessage() {
    return MESSAGE;
  }
}
