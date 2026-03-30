package com.barbearia.barbearia_api.service;

import com.barbearia.barbearia_api.infrastructure.dto.AgendamentoRequest;
import com.barbearia.barbearia_api.infrastructure.entity.Agendamento;
import com.barbearia.barbearia_api.infrastructure.entity.Barbeiro;
import com.barbearia.barbearia_api.infrastructure.entity.Cliente;
import com.barbearia.barbearia_api.infrastructure.entity.Servico;
import com.barbearia.barbearia_api.infrastructure.repository.AgendamentoRepository;
import com.barbearia.barbearia_api.infrastructure.repository.BarbeiroRepository;
import com.barbearia.barbearia_api.infrastructure.repository.ClienteRepository;
import com.barbearia.barbearia_api.infrastructure.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final BarbeiroRepository barbeiroRepository;
    private final ServicoRepository servicoRepository;

    @Transactional
    public Agendamento criar(AgendamentoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Barbeiro barbeiro = barbeiroRepository.findById(request.getBarbeiroId())
                .orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));

        Servico servico = servicoRepository.findById(request.getServicoId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setBarbeiro(barbeiro);
        agendamento.setServico(servico);
        agendamento.setDataHora(request.getDataHora());
        agendamento.setStatus("AGENDADO");

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listar() {
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .or(() -> { throw new RuntimeException("Agendamento não encontrado"); });
    }

    @Transactional
    public void deletar(Long id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }
}