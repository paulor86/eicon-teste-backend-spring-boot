package com.teste.eicon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.eicon.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
