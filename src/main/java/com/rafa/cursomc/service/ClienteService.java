package com.rafa.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafa.cursomc.model.Cliente;
import com.rafa.cursomc.repository.ClienteRepository;
import com.rafa.cursomc.service.exception.ObjectNotFoundException;

@Service
public class ClienteService
{
	@Autowired
	private ClienteRepository clientes;
	
	public Cliente findById(Integer id)
	{
		Optional<Cliente> cliente = clientes.findById(id);
		
		return cliente.orElseThrow(() -> 
			   new ObjectNotFoundException("Objeto não encontrado: Id: "+id+"- Tipo: "+Cliente.class.getName() ));
	}
}
