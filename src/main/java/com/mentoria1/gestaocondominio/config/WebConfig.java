package com.mentoria1.gestaocondominio.config;

import com.mentoria1.gestaocondominio.oauth.CheckAuthenticationInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private CheckAuthenticationInterceptor oauthenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(oauthenticationInterceptor).addPathPatterns("/**");
    }
}
