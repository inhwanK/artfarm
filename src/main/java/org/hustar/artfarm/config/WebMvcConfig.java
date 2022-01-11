package org.hustar.artfarm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	private final long MAX_AGE_SECS = 3600;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**")
				.allowedOrigins("http://ec2-13-124-134-65.ap-northeast-2.compute.amazonaws.com/:8080")
				.allowedMethods("GET","POST","PUT","PATCH","DELETE","OPTIONS")
				.allowedHeaders("*")
				.allowCredentials(true)
				.maxAge(MAX_AGE_SECS);
		
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addCorsMappings(registry);
	}
	
	
}
