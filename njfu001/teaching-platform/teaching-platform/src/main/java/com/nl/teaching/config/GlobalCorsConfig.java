package com.nl.teaching.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer {
    @Value("${images.imagePath}")
    private String imagePath;

    @Value("${images.imageUrl}")
    private String imageUrl;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(imageUrl + "**")
                .addResourceLocations("file:" + imagePath);
    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")// 项目中的所有接口都支持跨域
                .allowedOriginPatterns("*").allowedOrigins("http://localhost:81") //允许哪些域能访问我们的跨域资源
                .allowedMethods("*")//允许的访问方法"POST", "GET", "PUT", "OPTIONS", "DELETE"等
                .allowedHeaders("*")//允许所有的请求header访问，可以自定义设置任意请求头信息
                .maxAge(3600);
    }
}