package com.barbearia.barbearia_api.controller;

import com.barbearia.barbearia_api.infrastructure.entity.Venda;
import com.barbearia.barbearia_api.service.VendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public Venda criar(@RequestBody Venda venda){
        return vendaService.salvar(venda);
    }

    @GetMapping
    public List<Venda> listar(){
        return vendaService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Venda> buscar(@PathVariable Long id){
        return vendaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        vendaService.deletar(id);
    }
}