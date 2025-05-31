package com.example.opensource.common.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringDocSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/movie/**",
                                "/api/v1/review/**"

                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {}) // HTTP Basic 인증 사용
                .formLogin(form -> {});     // 폼 로그인 허용

        return http.build();
    }

}
