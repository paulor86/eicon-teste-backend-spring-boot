package com.teste.eicon.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.teste.eicon.entities.Produto;
import com.teste.eicon.repositories.ProdutoRepository;
import com.teste.eicon.services.exceptions.DatabaseException;
import com.teste.eicon.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Produto insert(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto update(Long id, Produto produto) {
		try {
			Produto entity = produtoRepository.getOne(id);
			updateData(entity, produto);
			return produtoRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Produto entity, Produto produto) {
		entity.setNome(produto.getNome());
		entity.setDescricao(produto.getDescricao());
		entity.setPreco(produto.getPreco());
	}

	public void delete(Long id) {
		try {
			produtoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
