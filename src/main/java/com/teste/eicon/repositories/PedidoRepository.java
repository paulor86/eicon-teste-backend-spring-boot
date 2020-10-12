package com.teste.eicon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.eicon.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
