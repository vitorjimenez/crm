package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Cliente;
import com.gotech.sboot_crm.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLOutput;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }

    public void encontrarCliente(Long id) {
        try {
            System.out.println(repository.findById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        try {
            repository.save(cliente);
        } catch (RuntimeException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public void alterarCliente(Cliente cliente){
        try {
            repository.save(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void desativarCliente(Cliente cliente){
        try {
            Cliente toChange = repository.findById(cliente);
            toChange.setAtivo(false);
            repository.save(toChange);
        } catch (RuntimeException e) {
            System.out.println("Erro ao desativar cliente: " + e.getMessage());
        }
    }
}
