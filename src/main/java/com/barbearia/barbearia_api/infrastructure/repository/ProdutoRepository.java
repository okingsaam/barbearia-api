package com.barbearia.barbearia_api.infrastructure.repository;

import com.barbearia.barbearia_api.infrastructure.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}