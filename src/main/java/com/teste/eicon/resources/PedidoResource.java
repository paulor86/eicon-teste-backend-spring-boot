package com.teste.eicon.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.eicon.entities.Pedido;
import com.teste.eicon.services.PedidoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	public PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> pedidoList = pedidoService.findAll();
		return ResponseEntity.ok().body(pedidoList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido pedido = pedidoService.findById(id);
		return ResponseEntity.ok().body(pedido);
	}
}
