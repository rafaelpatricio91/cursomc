package com.rafa.cursomc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="pedido")
public class Pedido implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date instante;
	
//	@ManyToMany
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="id_endereco_entrega")
	private Endereco enderecoEntrega;
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido") // tudo bem pedido carregar seu pagamento
	private Pagamento pagamento;
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Date getInstante()
	{
		return instante;
	}
	public void setInstante(Date instante)
	{
		this.instante = instante;
	}
	public Produto getProduto()
	{
		return produto;
	}
	public void setProduto(Produto produto)
	{
		this.produto = produto;
	}
	public Endereco getEnderecoEntrega()
	{
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(Endereco enderecoEntrega)
	{
		this.enderecoEntrega = enderecoEntrega;
	}
	public Pagamento getPagamento()
	{
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento)
	{
		this.pagamento = pagamento;
	}
	public Cliente getCliente()
	{
		return cliente;
	}
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	public Pedido()
	{}
	
	
	
	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoEntrega)
	{
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}
	public Pedido(Integer id, Date instante, Produto produto, Endereco enderecoEntrega, Pagamento pagamento,
			Cliente cliente)
	{
		this.id = id;
		this.instante = instante;
		this.produto = produto;
		this.enderecoEntrega = enderecoEntrega;
		this.pagamento = pagamento;
		this.cliente = cliente;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
