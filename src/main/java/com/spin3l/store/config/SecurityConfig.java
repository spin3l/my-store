package com.spin3l.store.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws
                                                                              Exception {
        return httpSecurity
                .authorizeHttpRequests(registry -> {
                    registry
                            .requestMatchers(
                                    "/req/signup",
                                    "/css/**",
                                    "/js/**"
                            )
                            .permitAll();
                    registry
                            .anyRequest()
                            .authenticated();
                })
                .oauth2Login(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
