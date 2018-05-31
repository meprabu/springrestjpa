package com.prabu.myrestfulapi.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class RestfulsecurityConfig extends WebSecurityConfigurerAdapter{

	
	public void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable()
				.authorizeRequests().antMatchers("/","/login","/insert").permitAll();				
	}
	
}
