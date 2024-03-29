package com.rafa.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafa.cursomc.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>
{}
