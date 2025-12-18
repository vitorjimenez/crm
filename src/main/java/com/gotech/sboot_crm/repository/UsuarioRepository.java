package com.gotech.sboot_crm.repository;

import com.gotech.sboot_crm.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Long, Usuario> {
}
