package com.mentoria1.gestaocondominio.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "package com.mentoria1.gestaocondominio.client")
public class AppConfig {
}
