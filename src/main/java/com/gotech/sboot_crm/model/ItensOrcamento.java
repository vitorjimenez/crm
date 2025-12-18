package com.gotech.sboot_crm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "itens_orcamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItensOrcamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Estoque> itens;
}
