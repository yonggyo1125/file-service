package com.sparta.global.infrastructure.config;

import com.sparta.global.domain.FileProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(FileProperties.class)
public class FileConfig implements WebMvcConfigurer {
    private final FileProperties properties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler(properties.getUrl() + "/**")
               .addResourceLocations("file:///" + properties.getPath() + "/");
    }
}
