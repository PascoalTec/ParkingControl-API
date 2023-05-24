package com.api.parkingcontrol.configs.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFilter extends OncePerRequestFilter {
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{

            System.out.println("DEBUG");

            
            if(request.getHeader("Authorization") != null){
                // aqui vou fixar um negocio massa
                Authentication auth = TokenUtil.decodeToken(request);
                if(auth != null) {
                    SecurityContextHolder.getContext().setAuthentication(null);
                } else{
                    System.out.println("Erro no token");
                    ErroDTO erro = new ErroDTO(401, "Usuario nao autorizado para este sistema");
                    response.setStatus(erro.getStatus());
                    response.setContentType("application/json");
                    ObjectMapper mapper = new ObjectMapper();
                    response.getWriter().print(mapper.writeValueAsString(erro));
                    response.getWriter().flush();
                    return;
                }
            }
            // passa a requisição para frente
            filterChain.doFilter(request, response);
    }
}
