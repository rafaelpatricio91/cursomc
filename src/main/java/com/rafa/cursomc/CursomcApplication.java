package com.rafa.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafa.cursomc.model.Categoria;
import com.rafa.cursomc.model.Cidade;
import com.rafa.cursomc.model.Cliente;
import com.rafa.cursomc.model.Endereco;
import com.rafa.cursomc.model.Estado;
import com.rafa.cursomc.model.EstadoPagamento;
import com.rafa.cursomc.model.Pagamento;
import com.rafa.cursomc.model.PagamentoComBoleto;
import com.rafa.cursomc.model.PagamentoComCartao;
import com.rafa.cursomc.model.Pedido;
import com.rafa.cursomc.model.Produto;
import com.rafa.cursomc.model.TipoCliente;
import com.rafa.cursomc.repository.CategoriaRepository;
import com.rafa.cursomc.repository.CidadeRepository;
import com.rafa.cursomc.repository.ClienteRepository;
import com.rafa.cursomc.repository.EnderecoRepository;
import com.rafa.cursomc.repository.EstadoRepository;
import com.rafa.cursomc.repository.PagamentoRepository;
import com.rafa.cursomc.repository.PedidoRepository;
import com.rafa.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categorias;
	@Autowired
	private ProdutoRepository produtos;
	@Autowired
	private EstadoRepository estados;
	@Autowired
	private CidadeRepository cidades;
	@Autowired
	private ClienteRepository clientes;
	@Autowired
	private EnderecoRepository enderecos;
	@Autowired
	private PedidoRepository pedidos;
	@Autowired
	private PagamentoRepository pagamentos;
	
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
		Produto p3 = new Produto(null, "Impressora HP 18c", 260.0);
		
		c1.getProdutos().addAll(Arrays.asList(p2,p3));
		c2.getProdutos().addAll(Arrays.asList(p1,p3));
		
		p1.getCategorias().addAll(Arrays.asList(c2));
		p2.getCategorias().addAll(Arrays.asList(c1));
		p3.getCategorias().addAll(Arrays.asList(c1,c2));
		
		categorias.saveAll(Arrays.asList(c1,c2) );
		produtos.saveAll(Arrays.asList(p1,p2,p3));
		
//		CIDADES E ESTADOS
		Estado es1 = new Estado(null, "RJ");
		Estado es2 = new Estado(null, "SP");
		Estado es3 = new Estado(null, "SC");
		
		Cidade ci1 = new Cidade(null, "Queimados", es1);
		Cidade ci2 = new Cidade(null, "Balneário Camboriú", es3);
		Cidade ci3 = new Cidade(null, "Guaratinguetá", es2);
		Cidade ci4 = new Cidade(null, "Diadema", es2);
		Cidade ci5 = new Cidade(null, "Osasco", es2);
		Cidade ci6 = new Cidade(null, "Paracambi", es1);
		Cidade ci7 = new Cidade(null, "Petrópolis", es1);
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
		
		estados.saveAll(Arrays.asList(es1,es2,es3) );
		cidades.saveAll(Arrays.asList(ci1,ci2,ci3,ci4,ci5,ci6,ci7) );
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, ci1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, ci2);
		
		cli1.getListaEnderecos().addAll(Arrays.asList(e1, e2));
		
		clientes.saveAll(Arrays.asList(cli1));
		enderecos.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getListaPedidos().addAll(Arrays.asList(ped1, ped2));
				
		pedidos.saveAll(Arrays.asList(ped1, ped2));
		pagamentos.saveAll(Arrays.asList(pagto1, pagto2));
		
//		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
//		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
//		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
//		
//		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
//		ped2.getItens().addAll(Arrays.asList(ip3));
//		
//		p1.getItens().addAll(Arrays.asList(ip1));
//		p2.getItens().addAll(Arrays.asList(ip3));
//		p3.getItens().addAll(Arrays.asList(ip2));
		
//		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));		

		
	}

}
