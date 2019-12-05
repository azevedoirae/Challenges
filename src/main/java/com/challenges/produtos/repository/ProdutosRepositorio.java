package com.challenges.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenges.produtos.model.Produto;

public interface ProdutosRepositorio extends JpaRepository<Produto, Long> {

}
