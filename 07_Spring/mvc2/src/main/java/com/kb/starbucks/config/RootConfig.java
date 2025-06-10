package com.kb.starbucks.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.kb.starbucks.vo", "com.kb.starbucks.dao", "com.kb.starbucks.service"})
public class RootConfig {}
