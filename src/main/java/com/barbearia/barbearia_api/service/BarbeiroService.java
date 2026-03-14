package com.barbearia.barbearia_api.service;

import com.barbearia.barbearia_api.infrastructure.entity.Barbeiro;
import com.barbearia.barbearia_api.infrastructure.repository.BarbeiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroService(BarbeiroRepository barbeiroRepository) {
        this.barbeiroRepository = barbeiroRepository;
    }

    public Barbeiro salvar(Barbeiro barbeiro) {
        return barbeiroRepository.save(barbeiro);
    }

    public List<Barbeiro> listar() {
        return barbeiroRepository.findAll();
    }

    public Optional<Barbeiro> buscarPorId(Long id) {
        return barbeiroRepository.findById(id);
    }

    public void deletar(Long id) {
        barbeiroRepository.deleteById(id);
    }
}