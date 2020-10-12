package com.teste.eicon.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.teste.eicon.entities.Categoria;
import com.teste.eicon.entities.ItemPedido;
import com.teste.eicon.entities.Pagamento;
import com.teste.eicon.entities.Pedido;
import com.teste.eicon.entities.Produto;
import com.teste.eicon.entities.Usuario;
import com.teste.eicon.entities.enums.StatusPedido;
import com.teste.eicon.repositories.CategoriaRepository;
import com.teste.eicon.repositories.ItemPedidoRepository;
import com.teste.eicon.repositories.PedidoRepository;
import com.teste.eicon.repositories.ProdutoRepository;
import com.teste.eicon.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	public PedidoRepository pedidoRepository;
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	@Autowired
	public ItemPedidoRepository itemPedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Eletronicos");
		Categoria categoria2 = new Categoria(null, "Books");
		Categoria categoria3 = new Categoria(null, "Computadores");
		
		Produto produto1 = new Produto(null, "The Lord of the Rings", "O Senhor dos Anéis é um livro de alta fantasia.", 90.5);
		Produto produto2 = new Produto(null, "Smart TV", "40 Polegadas com Youtube, Netflix, Globo Play.", 2190.0);
		Produto produto3 = new Produto(null, "Macbook Pro", "Notebooks mais potentes da Apple, com processadores rápidos.", 1250.0);
		Produto produto4 = new Produto(null, "PC Gamer", "Monitor LED Intel Core i5 8GB HD 500GB.", 1200.0);
		Produto produto5 = new Produto(null, "Harry Potter", "Narra as aventuras de um jovem chamado Harry James Potter.", 100.99);

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		Usuario usuario1 = new Usuario(null, "Paulo");
		Usuario usuario2 = new Usuario(null, "Roberto");
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2020-10-12T11:13:30Z"), StatusPedido.PAGAMENTO_EFETUADO, usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2020-10-12T11:13:30Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2020-10-12T11:13:30Z"), StatusPedido.PEDIDO_ENTREGEUE, usuario1);
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
		produto1.getCategorias().add(categoria2);
		produto2.getCategorias().add(categoria1);
		produto2.getCategorias().add(categoria3);
		produto3.getCategorias().add(categoria3);
		produto4.getCategorias().add(categoria3);
		produto5.getCategorias().add(categoria2);
		
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 7, produto1.getPreco());
		ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 15, produto3.getPreco());
		ItemPedido itemPedido3 = new ItemPedido(pedido2, produto3, 2, produto3.getPreco());
		ItemPedido itemPedido4 = new ItemPedido(pedido3, produto5, 2, produto5.getPreco());
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3, itemPedido4));
		
		Pagamento pagamento1 = new Pagamento(null, Instant.parse("2020-10-12T17:53:07Z"), pedido1);
		Pagamento pagamento2 = new Pagamento(null, Instant.parse("2020-10-12T18:53:07Z"), pedido2);
		pedido1.setPagamento(pagamento1);
		pedido2.setPagamento(pagamento2);
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
	}

}
