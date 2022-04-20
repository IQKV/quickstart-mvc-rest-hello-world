package org.ujar.sample.helloworldrest.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ujar.sample.helloworldrest.dto.ErrorResponse;
import org.ujar.sample.helloworldrest.dto.Greeting;

@RestController
@Tag(name = "Hello World controller", description = "API for greeting")
@RequestMapping("/v1/hello-world")
@Validated
@Slf4j
public class HelloWorldController {

  @GetMapping
  @Operation(
      description = "Generate greeting",
      responses = {
          @ApiResponse(responseCode = "200",
                       description = "Success"),
          @ApiResponse(responseCode = "500",
                       description = "Internal error",
                       content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
          @ApiResponse(responseCode = "400",
                       description = "Bad request",
                       content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
      })
  public ResponseEntity<Greeting> getGreeting() {
    var greeting = new Greeting();
    log.info("Send RESTFul API Response with {} message.", greeting.getMessage());
    return new ResponseEntity<>(greeting, HttpStatus.OK);
  }
}
