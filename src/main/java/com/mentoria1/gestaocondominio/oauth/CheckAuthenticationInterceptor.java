package com.mentoria1.gestaocondominio.oauth;

import com.mentoria1.gestaocondominio.service.JWTService;
import com.mentoria1.gestaocondominio.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

import static com.mentoria1.gestaocondominio.utils.AppMenssages.WITHOUT_AUTHORIZATION;

@Component
@RequiredArgsConstructor
public class CheckAuthenticationInterceptor implements HandlerInterceptor {

    private final JWTService jwtService;
    private final UsuarioService usuarioService;
    private final UsuarioAppContext usuarioAppContext;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {

        if(handler instanceof HandlerMethod method){
            try {
                PreAutorizado preAutorizadoAnnotation = method.getMethodAnnotation(PreAutorizado.class);
                if (Objects.isNull(preAutorizadoAnnotation))
                    return true;

                var token = getTokenFromRequest(request);
                var email = jwtService.validarTokenAndGetEmailUsuario(token);
                var usuario = usuarioService.obterUsuario(email);
                usuarioAppContext.setUsuario(usuario);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(WITHOUT_AUTHORIZATION);
                return false;
            }
        }
        return true;
    }

    private String getTokenFromRequest(HttpServletRequest request){
        var token = request.getHeader("Authorization");
        return  token.split("Bearer")[1];
    }
}
