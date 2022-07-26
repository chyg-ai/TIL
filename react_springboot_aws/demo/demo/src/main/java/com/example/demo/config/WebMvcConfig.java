package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	private final long MAX_AGE_SECS=3600;
	
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:3000") // Origin : localhost:3000인 경우
				.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // HTTP 메서드 허용
				.allowedHeaders("*") // 헤더 및 인증 정보 모두 허용
				.allowCredentials(true)
				.maxAge(MAX_AGE_SECS);
	}
}
