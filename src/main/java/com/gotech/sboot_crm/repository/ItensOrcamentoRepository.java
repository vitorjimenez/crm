package com.gotech.sboot_crm.repository;

import com.gotech.sboot_crm.model.ItensOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensOrcamentoRepository extends JpaRepository<ItensOrcamento, Long> {
    ItensOrcamento findById(ItensOrcamento itemOrcamento);
}
