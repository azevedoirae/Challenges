package com.challenges.produtos.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenges.produtos.model.Produto;
import com.challenges.produtos.repository.ProdutosRepositorio;

@RestController
@RequestMapping("/produtos")
public class ProdutosResource {
	
	@Autowired
	private ProdutosRepositorio repositorio;
	
	@PostMapping
	public Produto adicionar(@Valid @RequestBody Produto produto) {
		return repositorio.save(produto);
	}
	
	@GetMapping
	public List<Produto> listar() {
		return repositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscar(@PathVariable Long id) {
		Produto produto = repositorio.findOne(id);
		
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(produto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Produto produto) {
		Produto existente = repositorio.findOne(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(produto, existente, "id");
		
		existente = repositorio.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Produto produto = repositorio.findOne(id);
		
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		
		repositorio.delete(produto);
		
		return ResponseEntity.noContent().build();
	}
}











