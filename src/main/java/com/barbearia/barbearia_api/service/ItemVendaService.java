package com.barbearia.barbearia_api.service;

import com.barbearia.barbearia_api.infrastructure.entity.ItemVenda;
import com.barbearia.barbearia_api.infrastructure.repository.ItemVendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    public ItemVenda salvar(ItemVenda itemVenda) {
        return itemVendaRepository.save(itemVenda);
    }

    public List<ItemVenda> listar() {
        return itemVendaRepository.findAll();
    }

    public Optional<ItemVenda> buscarPorId(Long id) {
        return itemVendaRepository.findById(id);
    }

    public void deletar(Long id) {
        itemVendaRepository.deleteById(id);
    }
}

