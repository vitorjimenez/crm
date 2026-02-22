package com.gotech.sboot_crm.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double preco;
    private String name;
    private boolean ativo;
    private int quantidade;

    public boolean isValid(Item item){
        return item.getPreco() != 0
                || item.getName() != null && !item.getName().isEmpty()
                || item.getQuantidade() != 0;
    }
}
