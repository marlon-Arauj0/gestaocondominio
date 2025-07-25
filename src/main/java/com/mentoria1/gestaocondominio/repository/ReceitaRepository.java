package com.mentoria1.gestaocondominio.repository;

import com.mentoria1.gestaocondominio.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
