package org.example.notetaker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@ComponentScan("org.example.notetaker")
@EnableWebMvc
public class WebAppRootConfig {
}
