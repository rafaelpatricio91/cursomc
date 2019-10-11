package com.rafa.cursomc.model;

public enum TipoCliente
{
	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica");
	
	private String descricao;
	private int codigo;

	private TipoCliente(int codigo, String descricao)
	{
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getDescricao()
	{
		return descricao;
	}

	public int getCodigo()
	{
		return codigo;
	}
	
	public static TipoCliente toEnum(Integer cod)
	{
		if (cod == null)
		{
			return null;
		}
		
		for (TipoCliente c : TipoCliente.values())
		{
			if(cod.equals(c.getCodigo()))
			{
				return c;
			}
		}
		
		throw new IllegalArgumentException("Id inválido : "+cod);
	}
	
}
