package com.example.springnative.config.aot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(AppRuntimeHintsRegistrar.class)
@Configuration
public class AOTConfig {
}
