package com.aaslin.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class RoleBasedAccess {
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withUsername("admin")
				.password("{noop}admin123")
				.roles("ADMIN")
				.build();

		UserDetails admin = User.withUsername("harika")
				.password("{noop}harika123")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(admin,user);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/admin/dashboard").hasRole("ADMIN")
				.requestMatchers("/api/user/profile").hasRole("USER")
				.requestMatchers("/api/hello").permitAll()
				.anyRequest().authenticated()
				)

		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
