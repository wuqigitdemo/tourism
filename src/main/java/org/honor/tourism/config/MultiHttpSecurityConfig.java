package org.honor.tourism.config;

import org.honor.tourism.service.impl.CustomUserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@EnableWebSecurity
public class MultiHttpSecurityConfig {

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		
		@Bean
		UserDetailsService customUserService() {
			return new CustomUserServiceImpl();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(customUserService());
		}
		
		protected void configure(HttpSecurity http) throws Exception {
			http.headers().frameOptions().disable();
			http
				.antMatcher("/api/**")
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/easyui/**").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/login/register").permitAll()
				.antMatchers("/login/login").permitAll()
//				.antMatchers("/persons/**").hasRole("USER")
				.anyRequest()
//				.permitAll()
				.authenticated().and()
				.httpBasic()
				;
		}
		
	}

	@Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		
		@Bean
		UserDetailsService customUserService() {
			return new CustomUserServiceImpl();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(customUserService());
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.headers().frameOptions().disable();
			http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/easyui/**").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/login/register").permitAll()
				.antMatchers("/login/login").permitAll()
//				.antMatchers("/persons/**").hasRole("USER")
				.anyRequest()
//				.permitAll()
				.authenticated().and()
//				.httpBasic()
				.formLogin()
					.loginPage("/login")
					.permitAll()
				.and()
				.logout().permitAll()
				;
		}
		
	}
	
}
