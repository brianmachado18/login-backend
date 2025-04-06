package com.demoConcepto.demo.controllers;

import com.demoConcepto.demo.dto.AuthRequest;
import com.demoConcepto.demo.dto.AuthResponse;
import com.demoConcepto.demo.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demoConcepto.demo.repositories.UsuarioRepository;
import com.demoConcepto.demo.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UsuarioRepository usuarioRepository;

    public AuthController(AuthService authService, UsuarioRepository usuarioRepository) {
        this.authService = authService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/alta")
    public ResponseEntity<String> registrar (@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("OK");
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request){
        try {
            String token = authService.login(request).getToken();
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
