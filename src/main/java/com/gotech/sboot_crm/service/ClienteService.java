package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Cliente;
import com.gotech.sboot_crm.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLOutput;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private String response;

    public ClienteService(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }

    public String encontrarCliente(Long id) {
        if(id == null || id.toString().equals("")) {return "O ID não pode ser nulo.";}
        try {
            Optional<Cliente> cliente = repository.findById(id);
            if(cliente.isEmpty()) {
                response = "Cliente não encontrado.";
            } else {
                response = cliente.get().toString();
            }
        } catch (Exception e) {
            response = "Falha ao encontrar cliente.";
            System.out.println(e.getMessage());
        }
        return response;
    }

    public String cadastrarCliente(Cliente cliente) {
        try {
            response = "Sucesso ao cadastrar o cliente: " + cliente.getNome();
            repository.save(cliente);
        } catch (RuntimeException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
        return response;
    }

    public String alterarCliente(Cliente cliente){
        try {
            response = "Sucesso ao alterar cliente: " + cliente.getNome();
            repository.save(cliente);
        } catch (Exception e) {
            response = "Falha ao alterar cliente: " + e.getMessage();
        }
        return response;
    }

    public String desativarCliente(Cliente payload) {
        if (payload == null) {return "Falha ao desativar cliente";}
        Cliente cliente = repository.findById(payload);
        try {
            cliente.setAtivo(false);
            repository.save(cliente);
            response = "Sucesso ao desativar cliente";
        } catch (Exception e) {
            response = "Erro ao encontrar cliente: " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return response;
    }
}
