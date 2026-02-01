package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Item;
import com.gotech.sboot_crm.repository.ItemRepository;
import org.springframework.web.bind.annotation.RequestBody;

public class ItemService {

    private final ItemRepository repository;
    public ItemService(ItemRepository repo){
        this.repository = repo;
    }

    public void inserirItem (@RequestBody Item item){
        try {
            repository.save(item);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void alterarItem(){
        //TODO - Handlle logic
    }

    public void desativarItem(@RequestBody Item item){
        try {
            Item toChange = repository.findById(item);
            toChange.setAtivo(false);
            repository.save(toChange);
        } catch (RuntimeException e) {
            System.out.println("Erro ao desativar item: " + e.getMessage());
        }
    }

}
