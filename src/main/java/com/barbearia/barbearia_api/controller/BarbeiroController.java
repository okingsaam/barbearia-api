package com.barbearia.barbearia_api.controller;

import com.barbearia.barbearia_api.infrastructure.entity.Barbeiro;
import com.barbearia.barbearia_api.service.BarbeiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/barbeiros")
@RequiredArgsConstructor

public class BarbeiroController {

    private final BarbeiroService barbeiroService;

    @PostMapping
    public Barbeiro criar(@RequestBody Barbeiro barbeiro){
        return barbeiroService.salvar(barbeiro);
    }

    @GetMapping
    public List<Barbeiro> listar(){
        return barbeiroService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Barbeiro> buscar(@PathVariable Long id){
        return barbeiroService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Barbeiro atualizar(@PathVariable Long id, @RequestBody Barbeiro barbeiro) {
        return barbeiroService.atualizar(id, barbeiro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        barbeiroService.deletar(id);
    }
}