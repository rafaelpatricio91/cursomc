package com.rafa.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafa.cursomc.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>
{}
