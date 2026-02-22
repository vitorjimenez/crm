package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Item;
import com.gotech.sboot_crm.repository.ItemRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ItemService {

    private final ItemRepository repository;
    private String response;
    public ItemService(ItemRepository repo){
        this.repository = repo;
    }

    public String saveItems(List<Item> itemList) {
        try {
            for (Item item : itemList) {
                item.setAtivo(true);
                repository.save(item);
            }
            response = (itemList.size() == 1)  ? "Item salvo com sucesso" : "Itens salvos com sucesso";
        } catch (Exception e) {
            response = e.getMessage();
        }
        return response;
    }

    public void alterarItem(Item payload){
        try {
            repository.save(payload);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void desativarItem(Item item){
        try {
            Item toChange = repository.findById(item);
            toChange.setAtivo(false);
            repository.save(toChange);
        } catch (RuntimeException e) {
            System.out.println("Erro ao desativar item: " + e.getMessage());
        }
    }

    public String excluirItem(Item item) {
        try {

        }
    }

}
