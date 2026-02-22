package com.gotech.sboot_crm.controller;

import com.gotech.sboot_crm.model.Item;
import com.gotech.sboot_crm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/encontrar/{id}")
    public ResponseEntity<String> getItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItem(id));
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> cadastrarItem(@RequestBody List<Item> itemList) {
        return ResponseEntity.ok(itemService.saveItems(itemList));
    }

    @PostMapping(value = "/desativar")
    public ResponseEntity<String> desativarItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.desativarItem(item));
    }

    @DeleteMapping(value = "/excluir")
    public ResponseEntity<String> excluirItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.excluirItem(item));
    }

}
