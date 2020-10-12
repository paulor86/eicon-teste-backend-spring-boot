package com.teste.eicon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.eicon.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
