package com.exterro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.exterro.service.JpaUserDetailsService;

@Configuration
public class SecurityConfig {
	
	private final JpaUserDetailsService jpaUserDetailsService;
		
	public SecurityConfig(JpaUserDetailsService jpaUserDetailsService) {
		super();
		this.jpaUserDetailsService = jpaUserDetailsService;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.ignoringRequestMatchers("/home/**"))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/home/**").permitAll()
						.requestMatchers("/cars/**").hasAnyRole("USER","ADMIN")
						.requestMatchers("/admin/**").hasAnyRole("ADMIN")
						.anyRequest().authenticated())
				.userDetailsService(jpaUserDetailsService)
				.formLogin().and().build();
				
	}
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
