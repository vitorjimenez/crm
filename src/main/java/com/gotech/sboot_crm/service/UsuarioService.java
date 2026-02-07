package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Usuario;
import com.gotech.sboot_crm.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public void criarUsuario(Usuario usuario){
        try {
            repository.save(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setUsuarioCargo(Usuario payload){
        try {
            Usuario usuario = repository.findById(payload);
            usuario.setCargo(payload.getCargo());
            repository.save(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void alterarUsuario(Usuario payload){
        try {
            Usuario usuario = repository.findById(payload);
            usuario.setAtivo(payload.isAtivo());
            usuario.setName(payload.getName());
            usuario.setCargo(payload.getCargo());
            usuario.setEmail(payload.getEmail());
            usuario.setTelefone(payload.getTelefone());
            usuario.setSenha(payload.getSenha());
            repository.save(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void desativarUsuario(Usuario payload){
        try {
            Usuario usuario = repository.findById(payload);
            usuario.setAtivo(false);
            repository.save(usuario);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
