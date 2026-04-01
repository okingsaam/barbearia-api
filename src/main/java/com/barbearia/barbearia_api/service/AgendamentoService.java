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
        Cliente cliente = buscarCliente(request.getClienteId());


        Barbeiro barbeiro = buscarBarbeiro(request.getBarbeiroId());
        Servico servico = buscarServico(request.getServicoId());

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setBarbeiro(barbeiro);
        agendamento.setServico(servico);
        agendamento.setDataHora(request.getDataHora());
        agendamento.setStatus("AGENDADO");

        return agendamentoRepository.save(agendamento);
    }

    private Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));


    }

    private Barbeiro buscarBarbeiro(Long id) {
        return barbeiroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));
    }

    private Servico buscarServico(Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servico não encontrado"));

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

