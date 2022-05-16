package org.ujar.basics.rest.helloworld.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.ujar.basics.rest.helloworld.config.SecurityProperties;

@WebMvcTest(value = HelloWorldController.class)
@EnableConfigurationProperties(SecurityProperties.class)
class HelloWorldControllerTest {

  private final MockMvc mockMvc;

  public HelloWorldControllerTest(@Autowired MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  void getGreeting_Success() throws Exception {
    mockMvc.perform(
            get("/api/v1/hello-world"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(
            "{\"message\":\"Hello, World!\"}"
        ));
  }
}
