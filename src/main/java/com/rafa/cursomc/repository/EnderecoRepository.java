package com.rafa.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafa.cursomc.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>
{}
