package com.barbearia.barbearia_api.controller;

import com.barbearia.barbearia_api.infrastructure.entity.Produto;
import com.barbearia.barbearia_api.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor


public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public Produto criar(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }

    @GetMapping
    public List<Produto> listar(){
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscar(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        produtoService.deletar(id);
    }
}