package com.barbearia.barbearia_api.infrastructure.repository;

import com.barbearia.barbearia_api.infrastructure.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);

    List<Agendamento> findByDataHoraBetweenAndStatus(LocalDateTime inicio, LocalDateTime fim, String status);

    @Query("SELECT COALESCE(SUM(a.servico.preco), 0) FROM Agendamento a WHERE a.dataHora BETWEEN :inicio AND :fim AND a.status = 'CONCLUIDO'")
    Double faturamentoPorPeriodo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);

    @Query("SELECT COUNT(DISTINCT a.cliente.id) FROM Agendamento a WHERE a.dataHora BETWEEN :inicio AND :fim AND a.status = 'CONCLUIDO'")
    Long clientesAtendidosPorPeriodo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);
}