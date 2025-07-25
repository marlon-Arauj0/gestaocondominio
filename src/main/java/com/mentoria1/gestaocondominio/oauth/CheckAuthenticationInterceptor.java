package com.mentoria1.gestaocondominio.oauth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

public class CheckAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {

        var token = request.getHeader("token-app");
        var isTokenValid =  token != null && token.equals("abc123");

        if (isTokenValid)
            return true;

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write("Não tem autorização para esse serviço");
        return false;
    }
}
