package com.example.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.filter.JwtAuthenticationFilter;
import com.example.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final CustomUserDetailsService customUserDetailsService;
	
	public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, CustomUserDetailsService customUserDetailsService) {
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
		this.customUserDetailsService = customUserDetailsService;
	}

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/auth/**").permitAll()// 認証不要
				.requestMatchers("/api/words").permitAll()
				.requestMatchers("/api/scores/ranking").permitAll()
				.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // 追加
				.anyRequest().authenticated()
			)
			.userDetailsService(customUserDetailsService)
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			.cors(cors -> cors.configurationSource(corsConfigurationSource)); 
		return http.build();
	}
	
    @Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	return config.getAuthenticationManager();
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
    	CorsConfiguration config = new CorsConfiguration();
    	config.setAllowedOrigins(List.of("http://localhost:3000"));
    	config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
