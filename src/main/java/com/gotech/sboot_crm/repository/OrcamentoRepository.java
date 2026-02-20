package com.gotech.sboot_crm.repository;

import com.gotech.sboot_crm.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    Orcamento findById(Orcamento orcamento);
}
