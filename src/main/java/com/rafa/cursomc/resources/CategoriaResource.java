package com.rafa.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.cursomc.model.Categoria;
import com.rafa.cursomc.service.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource
{
	@Autowired
	private CategoriaService service;
	
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
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id)
	{
		Categoria categoria = service.findById(id);
		
		return ResponseEntity.ok(categoria);
	}
}
