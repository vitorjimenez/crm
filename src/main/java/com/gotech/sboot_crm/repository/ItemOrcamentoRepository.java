package com.gotech.sboot_crm.repository;

import com.gotech.sboot_crm.model.ItemOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrcamentoRepository extends JpaRepository<ItemOrcamento, Long> {
}
