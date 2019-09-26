package com.rafa.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafa.cursomc.model.Categoria;
import com.rafa.cursomc.model.Produto;
import com.rafa.cursomc.repository.CategoriaRepository;
import com.rafa.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categorias;
	@Autowired
	private ProdutoRepository produtos;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
//		INSTANCIA CATEGORIAS
		Categoria c1 = new Categoria(null,"Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
//		INSTANCIA PRODUTOS
		Produto p1 = new Produto(null, "Grampeador", 12.0);
		Produto p2 = new Produto(null, "Notebook Avell", 13000.0);
		Produto p3 = new Produto(null, "Impressora HP 18c", 28.0);
		
		c1.getProdutos().addAll(Arrays.asList(p2,p3));
		c2.getProdutos().addAll(Arrays.asList(p1,p3));
		
		p1.getCategorias().addAll(Arrays.asList(c2));
		p2.getCategorias().addAll(Arrays.asList(c1));
		p3.getCategorias().addAll(Arrays.asList(c1,c2));
		
		categorias.saveAll(Arrays.asList(c1,c2) );
		produtos.saveAll(Arrays.asList(p1,p2,p3));
	}

}
