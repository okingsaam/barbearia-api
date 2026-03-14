package com.barbearia.barbearia_api.service;

import com.barbearia.barbearia_api.infrastructure.entity.Servico;
import com.barbearia.barbearia_api.infrastructure.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public Servico salvar(Servico servico) {
        return servicoRepository.save(servico);
    }

    public List<Servico> listar() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> buscarPorId(Long id) {
        return servicoRepository.findById(id);
    }

    public void deletar(Long id) {
        servicoRepository.deleteById(id);
    }
}