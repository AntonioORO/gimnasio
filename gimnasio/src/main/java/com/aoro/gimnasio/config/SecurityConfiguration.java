package com.aoro.gimnasio.config;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aoro.gimnasio.config.auth.JwtAuthenticationFilter;
import com.aoro.gimnasio.config.auth.OnlineStoreAPIException;
import com.aoro.gimnasio.config.service.impl.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        AuthenticationManager authenticationManager = builder.build();

        return http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .antMatchers(GET, "/api/v1/testAdmission/allUsers").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers(GET, "/api/v1/testAdmission/onlyAdmin").hasAnyAuthority("ROLE_ADMIN")
               // .antMatchers(POST, "/gimnasio/api/v1/auth/registrar").hasAnyAuthority("ADMIN")
                .antMatchers(POST, "/gimnasio/api/v1/auth/actualizar").hasAnyAuthority("ADMIN")
                .antMatchers(POST, "/gimnasio/api/v1/auth/login").permitAll()
                .antMatchers(POST, "/gimnasio/api/v1/auth/registrar").permitAll()
                .antMatchers(POST, "/api/v1/auth/registrar").permitAll()
                
                .antMatchers("/gimnasio/api/v1/auth/**").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().authenticationManager(authenticationManager)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}