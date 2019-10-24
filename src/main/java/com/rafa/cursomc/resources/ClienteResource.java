package com.rafa.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.cursomc.model.Cliente;
import com.rafa.cursomc.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource
{
	@Autowired
	private ClienteService service;
	
	@GetMapping("/{id}")
	private ResponseEntity<?> buscarPorId(@PathVariable Integer id)
	{
		Cliente cliente = service.findById(id);
		
		return ResponseEntity.ok(cliente);
	}
}
