package com.mentoria1.gestaocondominio.repository;

import com.mentoria1.gestaocondominio.domain.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
