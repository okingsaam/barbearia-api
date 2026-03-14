package com.barbearia.barbearia_api.service;

import com.barbearia.barbearia_api.infrastructure.entity.Venda;
import com.barbearia.barbearia_api.infrastructure.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<Venda> listar() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> buscarPorId(Long id) {
        return vendaRepository.findById(id);
    }

    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }
}