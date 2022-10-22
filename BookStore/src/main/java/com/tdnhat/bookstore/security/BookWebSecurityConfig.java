package com.tdnhat.bookstore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BookWebSecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                // Spring Security should completely ignore URLs starting with /resources/
                .antMatchers("/resources/**", "/version");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**")
                .hasRole("USER").and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/booklist")
                .permitAll()
                .and()
                .logout().permitAll();
        return http.build();
    }
}
