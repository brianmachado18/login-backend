package com.demoConcepto.demo.repositories;
import com.demoConcepto.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByMail(String mail);
}
