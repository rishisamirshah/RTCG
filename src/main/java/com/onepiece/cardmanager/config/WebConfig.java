package com.onepiece.cardmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Revert back to the specific mapping for images
        registry
            .addResourceHandler("/images/**") // URL pattern to access images
            .addResourceLocations("classpath:/static/images/"); // Directory location within resources
    }
} 