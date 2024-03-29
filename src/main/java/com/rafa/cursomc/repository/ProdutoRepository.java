package com.rafa.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafa.cursomc.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>
{}
