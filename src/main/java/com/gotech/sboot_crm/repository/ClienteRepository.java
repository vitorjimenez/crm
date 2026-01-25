package com.gotech.sboot_crm.repository;

import com.gotech.sboot_crm.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findById (Cliente cliente);
}
