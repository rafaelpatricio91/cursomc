package com.rafa.cursomc.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource
{
//	@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public String listar()
	{
		return "REST crl";
	}
}
