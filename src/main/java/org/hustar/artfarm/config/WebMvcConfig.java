package org.hustar.artfarm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 임포트 패키지 주의.
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

//@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebMvcConfig extends WebSecurityConfigurerAdapter {

	private final long MAX_AGE_SECS = 3600;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		CorsConfiguration configuration = new CorsConfiguration();

		configuration.addAllowedOrigin("http://192.168.0.14:8080");

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
