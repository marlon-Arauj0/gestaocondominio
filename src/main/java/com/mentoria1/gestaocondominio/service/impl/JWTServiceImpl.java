package com.mentoria1.gestaocondominio.service.impl;

import com.mentoria1.gestaocondominio.dataTransferObjectDTO.UsuarioPayload;
import com.mentoria1.gestaocondominio.domain.Usuario;
import com.mentoria1.gestaocondominio.service.JWTService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTServiceImpl implements JWTService {

    private static final String ASSINATURA_TOKEN = "tGDHGRr+WZ8fOV7l3iokbdIweofCKeDW//nhshdh4N2lg+BZjBxDuVZzGVmwGE1l4iXxmYZcwPPh81tMOugvlA==";

    @Override
    public String gerarTokenJWT(Usuario usuario) {
       return Jwts
               .builder()
               .subject(usuario.getNome())
               .claims(construirPayload(usuario))
               .issuedAt(Date.from(Instant.now()))
               .expiration(dataExpiracaoToken())
               .signWith(obterSecretKey())
               .compact();
    }

    @Override
    public UsuarioPayload validarToken(String token) {
        return null;
    }

    private Map<String, Object> construirPayload(Usuario usuario){
        Map<String, Object> mapa =new HashMap<>();
        mapa.put("Email", usuario.getEmail());
        mapa.put("Admin", usuario.getAdmin());
        return mapa;
    }

    private Date dataExpiracaoToken(){
        var instant = Instant.now();
        var expiration = instant.plusSeconds(3600);
        return Date.from(expiration);
    }

    private SecretKey obterSecretKey(){
        return Keys.hmacShaKeyFor(ASSINATURA_TOKEN.getBytes());

    }
}
