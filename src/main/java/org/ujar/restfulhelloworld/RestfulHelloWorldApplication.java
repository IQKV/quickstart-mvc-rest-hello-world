package org.ujar.restfulhelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class RestfulHelloWorldApplication {
  public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(RestfulHelloWorldApplication.class);
    springApplication.setApplicationStartup(new BufferingApplicationStartup(2048));
    springApplication.run(args);
  }
}
