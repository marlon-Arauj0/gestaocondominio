package com.mentoria1.gestaocondominio.repository;

import com.mentoria1.gestaocondominio.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail (String email);
}
