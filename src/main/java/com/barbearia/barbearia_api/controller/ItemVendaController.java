package com.barbearia.barbearia_api.controller;

import com.barbearia.barbearia_api.infrastructure.entity.ItemVenda;
import com.barbearia.barbearia_api.service.ItemVendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens-venda")
@RequiredArgsConstructor
public class ItemVendaController {

    private final ItemVendaService itemVendaService;

    @PostMapping
    public ItemVenda criar(@RequestBody ItemVenda itemVenda) {
        return itemVendaService.salvar(itemVenda);
    }

    @GetMapping
    public List<ItemVenda> listar() {
        return itemVendaService.listar();
    }

    @GetMapping("/{id}")
    public Optional<ItemVenda> buscar(@PathVariable Long id) {
        return itemVendaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        itemVendaService.deletar(id);
    }
}
