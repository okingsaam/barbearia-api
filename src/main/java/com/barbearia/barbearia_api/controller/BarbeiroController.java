package com.barbearia.barbearia_api.controller;

import com.barbearia.barbearia_api.infrastructure.entity.Barbeiro;
import com.barbearia.barbearia_api.service.BarbeiroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/barbeiros")
public class BarbeiroController {

    private final BarbeiroService barbeiroService;

    public BarbeiroController(BarbeiroService barbeiroService) {
        this.barbeiroService = barbeiroService;
    }

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

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        barbeiroService.deletar(id);
    }
}