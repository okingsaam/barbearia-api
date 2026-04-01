package com.barbearia.barbearia_api.controller;

import com.barbearia.barbearia_api.infrastructure.entity.Servico;
import com.barbearia.barbearia_api.service.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor

public class ServicoController {

    private final ServicoService servicoService;

    @PostMapping
    public Servico criar(@RequestBody Servico servico){
        return servicoService.salvar(servico);
    }

    @GetMapping
    public List<Servico> listar(){
        return servicoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Servico> buscar(@PathVariable Long id){
        return servicoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        servicoService.deletar(id);
    }
}