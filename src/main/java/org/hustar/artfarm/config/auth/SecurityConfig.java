package org.hustar.artfarm.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.csrf().disable()
			.headers().frameOptions().disable()
		.and()
			.authorizeRequests()
			.antMatchers().authenticated()
			.anyRequest().permitAll();
//		.and()
//			.oauth2Login()
//			.userInfoEndpoint()
//			.userService();
		
//		http
//			.formLogin()
//			.loginPage("/oauth2/authorization/google")
//			.defaultSuccessUrl("/")
//			.permitAll();
		
		http
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);
	}
	
	

}
