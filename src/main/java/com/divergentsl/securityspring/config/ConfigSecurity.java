package com.divergentsl.securityspring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;


@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider authenticationProvider;
	
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return JdbcUserDetailsManager(dataSource);
	}
		
	
	/*
	 * @Bean public UserDetailsService userDetailsService() { var userDetailsService
	 * = new InMemoryUserDetailsManager(); var user =
	 * User.withUsername("poojaa").password("123456").authorities("read").build();
	 * userDetailsService.createUser(user); return userDetailsService; }
	 */
	  @Bean public PasswordEncoder passwordEncoder() { return
	  NoOpPasswordEncoder.getInstance(); }
	  
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  http.httpBasic(); http.authorizeRequests().anyRequest().authenticated(); }
	  
	 

}
