package com.employeeregistration.config;

import com.employeeregistration.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF protection for now (needed for H2 console)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/employees/register", "/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**").permitAll() // Allow H2 console
                        .anyRequest().authenticated()
                )
                .httpBasic();

        // Allow H2 console to work within an iframe (needed by the H2 console)
        http.headers().frameOptions().sameOrigin();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
