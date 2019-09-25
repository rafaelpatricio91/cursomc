package com.rafa.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.cursomc.model.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource
{
	
	
//	@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public List<Categoria> listar()
	{
		Categoria c = new Categoria();
		Categoria c2 = new Categoria();
		c.setId(1);
		c.setNome("Informática");
		
		c2.setId(2);
		c2.setNome("Escritório");
		
		List<Categoria> lista = new ArrayList<Categoria>();
		
		lista.add(c);
		lista.add(c2);
		
		return lista;
	}
}
