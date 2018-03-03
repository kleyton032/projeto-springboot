package com.sistema.cervejaria.repository.filter;

//classe para filtro de estilo utilizado na tela de pesquisa de estilo
public class EstiloFilter {

	private Long codigo;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
}
