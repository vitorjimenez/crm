package com.gotech.sboot_crm.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "itens_orcamento")
@Data
public class ItemOrcamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Orcamento orcamento;
    @OneToMany
    private List<Item> itemList;
    @CreationTimestamp
    @Column(name = "data_criacao")
    private Date createdDate;
}
