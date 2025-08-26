package com.aaslin.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

<<<<<<< HEAD
//@Configuration
//public class ConfigSecurity {
//
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(
//                User.withUsername("admin")
//                        .password(encoder.encode("admin123"))
//                        .roles("ADMIN")
//                        .build()
//        );
//        manager.createUser(
//                User.withUsername("user")
//                        .password(encoder.encode("user123"))
//                        .roles("USER")
//                        .build()
//        );
//        return manager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @SuppressWarnings("removal")
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .authorizeHttpRequests()
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic(); 
//        return http.build();
//    }
//}
=======
@Configuration
public class ConfigSecurity {

   @Bean
   public UserDetailsService userDetailsService(PasswordEncoder encoder) {
       InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
       manager.createUser(
               User.withUsername("admin")
                       .password(encoder.encode("admin123"))
                       .roles("ADMIN")
                       .build()
       );
       manager.createUser(
               User.withUsername("user")
                       .password(encoder.encode("user123"))
                       .roles("USER")
                       .build()
       );
       return manager;
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.csrf().disable()
           .authorizeHttpRequests()
           .anyRequest().authenticated()
           .and()
           .httpBasic(); // test easily with Postman
       return http.build();
   }
}
>>>>>>> 9cee4792e66a55232df7aedd097895fbc5b44705

