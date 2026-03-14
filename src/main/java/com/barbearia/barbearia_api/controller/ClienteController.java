package com.barbearia.barbearia_api.controller;

import com.barbearia.barbearia_api.infrastructure.entity.Cliente;
import com.barbearia.barbearia_api.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

   public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
   }
   @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
          return clienteService.salvarCliente(cliente);
    }
    @GetMapping("/{id}")
    public Optional<Cliente> buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }
}
