package com.gotech.sboot_crm.repository;

import com.gotech.sboot_crm.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Estoque findById(Estoque estoque);
}
