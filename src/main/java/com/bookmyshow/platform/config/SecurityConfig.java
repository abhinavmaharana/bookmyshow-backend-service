package com.bookmyshow.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/v1**")
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/swagger-ui/index.html").hasRole("USER")
                        .requestMatchers("/api/v1**").hasRole("USER")
                        .requestMatchers("/api/v1/cinemas/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/shows/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/movies/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
}
