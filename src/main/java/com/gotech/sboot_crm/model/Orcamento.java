package com.gotech.sboot_crm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orcamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orcamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeOrcamento;
    private String criadoPor;
    private ItensOrcamento itensOrcamento;
    private String statusOrcamento;
    private Double preco;
    private Date createdDate;
}
