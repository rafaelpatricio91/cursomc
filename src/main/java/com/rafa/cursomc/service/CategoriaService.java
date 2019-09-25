package com.rafa.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafa.cursomc.model.Categoria;
import com.rafa.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService
{
	@Autowired
	CategoriaRepository categorias;
	
	public Categoria findById(Integer id)
	{
		Optional<Categoria> categoria = categorias.findById(id);
		
		return categoria.orElse(null);
	}
}
