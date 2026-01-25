package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Cliente;
import com.gotech.sboot_crm.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLOutput;
import java.util.Optional;

public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }

    public void cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            repository.save(cliente);
        } catch (RuntimeException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public void alterarCliente(@RequestBody Cliente cliente){
        //TO DO - Criar logica de alterar cliente, usar o Cadastrar cliente
    }

    public void desativarCliente(@RequestBody Cliente cliente){
        try {
            Cliente toChange = repository.findById(cliente);
            toChange.setAtivo(false);
            repository.save(toChange);
        } catch (RuntimeException e) {
            System.out.println("Erro ao desativar cliente: " + e.getMessage());
        }
    }
}
