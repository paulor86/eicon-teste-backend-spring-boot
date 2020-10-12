package com.teste.eicon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.eicon.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
