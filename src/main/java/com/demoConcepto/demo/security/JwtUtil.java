package com.demoConcepto.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.demoConcepto.demo.models.Usuario;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "mi-clave-super-secreta-de-32-bytes!!!"; // tiene que tener 32+ caracteres

    public String generateToken(String mail) {
        return Jwts.builder()
                .setSubject(mail)
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

}
