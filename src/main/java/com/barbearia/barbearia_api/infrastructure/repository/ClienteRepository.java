package com.barbearia.barbearia_api.infrastructure.repository;

import com.barbearia.barbearia_api.infrastructure.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}