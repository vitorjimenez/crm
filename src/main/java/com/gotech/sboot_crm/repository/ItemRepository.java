package com.gotech.sboot_crm.repository;

import com.gotech.sboot_crm.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Consumer;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findById(Item itemOrcamento);
}
