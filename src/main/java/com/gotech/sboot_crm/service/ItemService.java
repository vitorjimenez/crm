package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Item;
import com.gotech.sboot_crm.repository.ItemRepository;

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
            response = (itemList.size() == 1) ? "Item salvo com sucesso" : "Itens salvos com sucesso.";
        }
        return response;
    }

    public String alterarItem(Item payload){
        Item toChange = repository.findById(payload);
        try {
            toChange.setPreco(payload.getPreco());
            toChange.setName(payload.getName());
            toChange.setQuantidade(payload.getQuantidade());
            repository.save(toChange);
            response = "Item alterado com sucesso";
        } catch (Exception e) {
            response = e.getMessage();
        }
        return response;
    }

    public String desativarItem(Item item){
        if(!item.isValid(item)) return response = "Algo inesperado aconteceu.";
        try {
            Item toChange = repository.findById(item);
            toChange.setAtivo(false);
            repository.save(toChange);
            response = "Sucesso ao desativar item.";
        } catch (RuntimeException e) {
            response = "Erro ao desativar item: " + e.getMessage();
        }
        return response;
    }

    public String excluirItem(Item item) {
        try {
            repository.delete(item);
            response = "Item excluido com sucesso.";
        } catch (Exception e) {
            response = "Houve uma falha em excluir o item. Mensagem de erro: " + e.getMessage();
        }
        return response;
    }

}
