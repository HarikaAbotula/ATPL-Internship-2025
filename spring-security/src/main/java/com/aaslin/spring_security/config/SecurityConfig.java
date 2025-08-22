package com.aaslin.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.aaslin.spring_security.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired 
	private CustomUserDetailService customUserDetailService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
	    AuthenticationManagerBuilder builder =
	            http.getSharedObject(AuthenticationManagerBuilder.class);

	    builder.userDetailsService(customUserDetailService)
	           .passwordEncoder(passwordEncoder());

	    return builder.build();
	}

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/admin/dashboard").hasRole("ADMIN")
				.requestMatchers("/api/user/profile").hasRole("USER")
				.requestMatchers("/api/dev").permitAll()
				.anyRequest().authenticated()
		       )
		.formLogin(Customizer.withDefaults());
		return http.build();
	}
}

