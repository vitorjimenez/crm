package com.gotech.sboot_crm.model;

import com.gotech.sboot_crm.service.type.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orcamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orcamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeOrcamento;
    @OneToOne
    private Usuario criadoPor;
    @OneToOne
    private ItemOrcamento itemOrcamento;
    private Status statusOrcamento;
    private Double preco;
    private Date createdDate;

    public boolean isValid(Orcamento orcamento) {
        return orcamento.getNomeOrcamento() != null && !orcamento.getNomeOrcamento().isEmpty()
                || orcamento.getCriadoPor() != null
                || orcamento.getItemOrcamento() != null
                || orcamento.getPreco() != null && orcamento.getPreco() > 0
                || orcamento.getStatusOrcamento() != null;
    }
}
