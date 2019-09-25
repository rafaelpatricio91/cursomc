package com.rafa.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafa.cursomc.model.Categoria;
import com.rafa.cursomc.repository.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categorias;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		Categoria c = new Categoria();
		Categoria c2 = new Categoria();
		Categoria c3 = new Categoria();
		Categoria c4 = new Categoria();
		
		c.setId(null);
		c.setNome("Informática");
		
		c2.setId(null);
		c2.setNome("Escritório");
		
		c3.setId(null);
		c3.setNome("Farmácia");
		
		c4.setId(null);
		c4.setNome("Sacolão");
		
		categorias.saveAll(Arrays.asList(c,c2,c3,c4) );
	}

}
