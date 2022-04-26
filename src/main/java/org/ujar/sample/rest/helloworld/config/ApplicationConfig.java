package org.ujar.sample.rest.helloworld.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.ujar.starter.rest.logbook.LogbookJsonBodyFilter;
import org.ujar.starter.rest.logbook.LogbookResponseOnStatus;

@Configuration
// Use custom logbook strategy
@LogbookResponseOnStatus
// Remove CompactingJsonBodyFilter from logbook
@LogbookJsonBodyFilter
@EnableConfigurationProperties(SecurityProperties.class)
public class ApplicationConfig {
}
