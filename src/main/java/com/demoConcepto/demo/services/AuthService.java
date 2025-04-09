package com.demoConcepto.demo.services;

import com.demoConcepto.demo.dto.AuthRequest;
import com.demoConcepto.demo.dto.AuthResponse;
import com.demoConcepto.demo.models.Usuario;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.demoConcepto.demo.repositories.UsuarioRepository;
import com.demoConcepto.demo.security.JwtUtil;

@Service
@Data
@AllArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;
    private PasswordEncoder passwordEncoder;

    public String login(AuthRequest authRequest){
        Usuario usuario = usuarioRepository.findByMail(authRequest.getMail());
        if(usuario != null && passwordEncoder.matches(authRequest.getPass(), usuario.getPass())){
            return jwtUtil.generateToken(usuario.getMail());
        }else{
            throw new RuntimeException("Usuario no encontrado o Contraseña incorrecta");
        }
    }
}
