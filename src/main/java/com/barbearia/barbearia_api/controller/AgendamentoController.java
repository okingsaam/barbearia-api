package com.barbearia.barbearia_api.controller;

import com.barbearia.barbearia_api.infrastructure.dto.AgendamentoRequest;
import com.barbearia.barbearia_api.infrastructure.entity.Agendamento;
import com.barbearia.barbearia_api.service.AgendamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public Agendamento criar(@RequestBody AgendamentoRequest request) {
        return agendamentoService.criar(request);
    }

    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Agendamento> buscar(@PathVariable Long id) {
        return agendamentoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        agendamentoService.deletar(id);
    }
}