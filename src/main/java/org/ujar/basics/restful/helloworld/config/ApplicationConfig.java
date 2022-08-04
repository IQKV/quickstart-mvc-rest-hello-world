package org.ujar.basics.restful.helloworld.config;

import org.springframework.context.annotation.Configuration;
import org.ujar.boot.starter.logbook.LogbookJsonBodyFilter;
import org.ujar.boot.starter.logbook.LogbookResponseOnStatus;

@Configuration
@LogbookResponseOnStatus
@LogbookJsonBodyFilter
class ApplicationConfig {
}
