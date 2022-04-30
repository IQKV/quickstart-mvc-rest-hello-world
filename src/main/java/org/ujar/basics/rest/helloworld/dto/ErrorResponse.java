package org.ujar.basics.rest.helloworld.dto;

import java.util.List;

public record ErrorResponse(List<Error> errors) {
  public record Error(String message) {
  }
}
