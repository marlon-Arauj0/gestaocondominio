package com.mentoria1.gestaocondominio.service.impl;

import com.mentoria1.gestaocondominio.domain.Usuario;
import com.mentoria1.gestaocondominio.oauth.enums.UsuarioClaims;
import com.mentoria1.gestaocondominio.service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.mentoria1.gestaocondominio.utils.AppMenssages.EXPIRED_TOKEN;

@Service
public class JWTServiceImpl implements JWTService {

    @Value("${app.token.expiration}")
    private Integer tokenExpiration;

    @Value("${app.token.signing_key}")
    private String assinaturaToken;

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
    public String validarTokenAndGetEmailUsuario(String token) {
        var payloadClaims = Jwts
                .parser()
                .verifyWith(obterSecretKey())
                .build()
                .parseSignedClaims(token);

        verificarExpiracaoToken(payloadClaims);
        return payloadClaims.getPayload().get(UsuarioClaims.email.name(), String.class);
    }

    private void verificarExpiracaoToken(Jws<Claims> claimsJws){
        Date dtExpiracaoToken = claimsJws.getPayload().getExpiration();
        if (new Date().after(dtExpiracaoToken))
            throw new JwtException(EXPIRED_TOKEN);
    }

    private Map<String, Object> construirPayload(Usuario usuario){
        Map<String, Object> mapa =new HashMap<>();
        mapa.put(UsuarioClaims.email.name(), usuario.getEmail());
        mapa.put(UsuarioClaims.admin.name(), usuario.getAdmin());
        return mapa;
    }

    private Date dataExpiracaoToken(){
        var instant = Instant.now();
        var expiration = instant.plusSeconds(tokenExpiration);
        return Date.from(expiration);
    }

    private SecretKey obterSecretKey(){
        return Keys.hmacShaKeyFor(assinaturaToken.getBytes());
    }
}
