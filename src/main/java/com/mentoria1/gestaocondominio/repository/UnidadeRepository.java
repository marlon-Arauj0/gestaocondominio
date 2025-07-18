package com.mentoria1.gestaocondominio.repository;

import com.mentoria1.gestaocondominio.domain.Unidade;
import com.mentoria1.gestaocondominio.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

    Optional<Unidade> findFirstByregistro (String registro);
}
