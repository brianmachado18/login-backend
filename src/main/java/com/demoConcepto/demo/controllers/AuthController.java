package com.demoConcepto.demo.controllers;

import com.demoConcepto.demo.dto.AuthRequest;
import com.demoConcepto.demo.dto.AuthResponse;
import com.demoConcepto.demo.models.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demoConcepto.demo.repositories.UsuarioRepository;
import com.demoConcepto.demo.services.AuthService;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;


    @PostMapping("/alta")
    public ResponseEntity<String> registrar (@RequestBody Usuario usuario){
        usuario.setPass(passwordEncoder.encode(usuario.getPass()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario creado");
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request){
        try {
            String token = authService.login(request);
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
