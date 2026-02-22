package com.gotech.sboot_crm.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private boolean ativo;
    @CreationTimestamp
    private Date createdDate;

    public boolean isValid(Cliente cliente){
        return cliente.getNome() != null && !cliente.getNome().isEmpty()
                && cliente.getEmail() != null && !cliente.getEmail().isEmpty()
                && cliente.getTelefone() != null && !cliente.getTelefone().isEmpty();
    }
}
