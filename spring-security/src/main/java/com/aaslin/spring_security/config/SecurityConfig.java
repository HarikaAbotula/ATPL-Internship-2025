//package com.aaslin.spring_security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.aaslin.spring_security.service.CustomUserDetailService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Autowired 
//	private CustomUserDetailService customUserDetailService;
//	
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//	
//	@Bean
//    public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
//        DaoAuthenticationProvider provider =
//            new DaoAuthenticationProvider(customUserDetailService);
//        provider.setPasswordEncoder(passwordEncoder);
//        return provider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
//            throws Exception {
//        return config.getAuthenticationManager();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable()) 
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/api/register","/api/dev").permitAll() 
//                .anyRequest().authenticated()         
//            )
//            .formLogin(form -> form
//            		.permitAll()
//            )
//            .logout(logout -> logout
//                .permitAll()
//            );
//
//        return http.build();
//        
//    }
//}

