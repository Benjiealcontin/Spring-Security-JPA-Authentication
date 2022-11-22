package com.operation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.operation.userdetailservice.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    private final JpaUserDetailsService myUserDetailsService;

    public SecurityConfig(JpaUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }
    
    
    @Bean
    public SecurityFilterChain filterChainApp1(HttpSecurity http) throws Exception {
        http
        .authorizeRequests(auth -> auth
        		.mvcMatchers("/").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/Successfully").authenticated()
                .mvcMatchers("/admin/dashboard").hasRole("ADMIN")
                .mvcMatchers("/user/dashboard").hasRole("USER")
                .anyRequest().authenticated()
        )
          .formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/login")
          .failureUrl("/login?error=loginError")
          .defaultSuccessUrl("/Successfully")
          
          .and()
          .logout()
          .logoutUrl("/logout")
          .logoutSuccessUrl("/login")
          .deleteCookies("JSESSIONID")
          
          .and()
          .exceptionHandling()
          .accessDeniedPage("/403")
          
          .and()
          .csrf().disable();
       return http.build();
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}