package com.demoConcepto.demo.services;

import com.demoConcepto.demo.dto.AuthRequest;
import com.demoConcepto.demo.dto.AuthResponse;
import com.demoConcepto.demo.models.Usuario;
import org.springframework.stereotype.Service;
import com.demoConcepto.demo.repositories.UsuarioRepository;
import com.demoConcepto.demo.security.JwtUtil;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    public AuthService(UsuarioRepository usuarioRepository, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse login(AuthRequest authRequest){
        Usuario usuario = usuarioRepository.findByMail(authRequest.getMail());
        if(usuario != null && usuario.getPass().equals(authRequest.getPass())){
            String token = jwtUtil.generateToken(usuario.getMail());
            return new AuthResponse(token);
        }else{
            throw new RuntimeException("Usuario no encontrado o Contraseña incorrecta");
        }
    }
}
