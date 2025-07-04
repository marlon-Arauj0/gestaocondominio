package com.mentoria1.gestaocondominio.repository;

import com.mentoria1.gestaocondominio.domain.Despesa;
import com.mentoria1.gestaocondominio.domain.enums.StatusDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query(value = "SELECT * FROM despesas d WHERE d.status = :status", nativeQuery = true)
    List<Despesa> lista(@Param("status") String status);

    @Query(value = "SELECT d FROM Despesa d WHERE d.status = :status")
    List<Despesa> listaV2(@Param("status") StatusDespesa status);

    List<Despesa> findAllByStatus(StatusDespesa status);
}
