package com.barbearia.barbearia_api.infrastructure.repository;

import com.barbearia.barbearia_api.infrastructure.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}