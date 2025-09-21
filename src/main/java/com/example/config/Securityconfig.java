package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class Securityconfig {

	@Autowired
    private UserDetailsService userDetailsService ;
	@Bean
    public SecurityFilterChain configuation(HttpSecurity http) throws Exception {
    	return http  		
    		.csrf(csrf->csrf.disable())   // Disable Cross-Site Request Forgery(CSRF) protection
    		.authorizeHttpRequests(auth->auth
    				.requestMatchers("/signup","/login").permitAll()
    				.anyRequest().authenticated())// Require authentication for every incoming HTTP request
    		.httpBasic(Customizer.withDefaults())// Use HTTP Basic Authentication (credentials sent in headers)
    		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    		.build();                          // Build and return the configured SecurityFilterChain
	}



    @Bean
    public AuthenticationProvider provider() {
    	DaoAuthenticationProvider provider=new DaoAuthenticationProvider(userDetailsService);
    	provider.setPasswordEncoder(new BCryptPasswordEncoder(12));    	
    	return provider;
    }
    
    @Bean
    public AuthenticationManager auth(AuthenticationConfiguration config) throws Exception {   	
    	return config.getAuthenticationManager();
    }
}
