package com.gotech.sboot_crm.controller;

import com.gotech.sboot_crm.model.Cliente;
import com.gotech.sboot_crm.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cliente")
@Controller
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getCliente (@PathVariable Long id){
        return ResponseEntity.ok(service.encontrarCliente(id));
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(service.cadastrarCliente(cliente));
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<String> alterarCliente(@RequestBody Cliente cliente) {
        try {
            service.alterarCliente(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/desativar")
    public ResponseEntity<String> desativarCliente(@RequestBody Cliente cliente) {
        try {
            service.desativarCliente(cliente);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
