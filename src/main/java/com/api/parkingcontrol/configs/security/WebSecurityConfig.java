package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()          // desabilito o csrf (porque eu que vou tratar a autenticação dos usuarios)
            .authorizeHttpRequests()   // agora as requisições http são passiveis de autorização
            .requestMatchers(HttpMethod.GET, "/parking-spot").permitAll()  // estou especificando quem é liberado
            .anyRequest().authenticated().and().cors();  // todas as outras urls terão necessidade de autenticação

            http.addFilterBefore(new MyFilter(), UsernamePasswordAuthenticationFilter.class);

            return http.build();

    }
    
}
