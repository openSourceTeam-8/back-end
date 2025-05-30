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
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/api/movie/**", // 기존 패턴
                                "/movie/**" // <<-- 이 라인을 추가해주세요.


                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {}) // HTTP Basic 인증 사용
                .formLogin(form -> {});     // 폼 로그인 허용

        return http.build();
    }

}
