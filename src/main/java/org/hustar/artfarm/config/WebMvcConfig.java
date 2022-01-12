package org.hustar.artfarm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// 임포트 패키지 주의.
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

//api 요청 권한 체크를 위한 어노테이션
//@EnableGlobalMethodSecurity(prePostEnabled = true)

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebMvcConfig extends WebSecurityConfigurerAdapter {

	private final long MAX_AGE_SECS = 3600;
	
	
	private final String frontIp = "http://10.1.4.106:8082";
	private final String testIp = "http://192.168.0.14:8080";
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		CorsConfiguration configuration = new CorsConfiguration();

		System.out.println("testIp > " +testIp);
		
		configuration.addAllowedOrigin(frontIp);
		configuration.addAllowedOrigin(testIp);
		
		configuration.addAllowedMethod("GET");
		configuration.addAllowedMethod("POST");
		configuration.addAllowedMethod("PUT");
		configuration.addAllowedMethod("PATCH");
		configuration.addAllowedMethod("DELETE");
		configuration.addAllowedMethod("OPTIONS");

		configuration.addAllowedHeader("*");
		configuration.setMaxAge(MAX_AGE_SECS);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		http
			.csrf().disable()
			.headers().frameOptions().disable()
		.and()
			.authorizeRequests()
			.antMatchers().authenticated()
			.anyRequest().permitAll()
		.and()
			.cors().configurationSource(source);
	}
}
