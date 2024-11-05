package com.iqkv.incubator.quickstart.mvcresthelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class MvcRestHelloWorldApplication {
  public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(MvcRestHelloWorldApplication.class);
    springApplication.setApplicationStartup(new BufferingApplicationStartup(2048));
    springApplication.run(args);
  }
}
