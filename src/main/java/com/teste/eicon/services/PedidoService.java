package com.teste.eicon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.eicon.entities.Pedido;
import com.teste.eicon.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	public PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.get();
	}
}
