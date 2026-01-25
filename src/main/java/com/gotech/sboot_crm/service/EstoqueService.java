package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Cliente;
import com.gotech.sboot_crm.model.Estoque;
import com.gotech.sboot_crm.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class EstoqueService {

    private final EstoqueRepository repository;
    public EstoqueService (EstoqueRepository repo){
        this.repository = repo;
    }

    public void inserirItem (@RequestBody Estoque estoque){
        try {
            repository.save(estoque);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void alterarItem(){
        //TODO - Handlle logic
    }

    public void desativarItem(@RequestBody Estoque item){
        try {
            Estoque toChange = repository.findById(item);
            toChange.setAtivo(false);
            repository.save(toChange);
        } catch (RuntimeException e) {
            System.out.println("Erro ao desativar item: " + e.getMessage());
        }
    }

}
