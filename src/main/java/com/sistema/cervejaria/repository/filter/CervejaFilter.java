package com.sistema.cervejaria.repository.filter;

import java.math.BigDecimal;

import com.sistema.cervejaria.model.Estilo;
import com.sistema.cervejaria.model.Origem;
import com.sistema.cervejaria.model.Sabor;

//classe para filtro de cerveja utilizado na tela de pesquisa de cerveja
public class CervejaFilter {

	private String sku;
	private String nome;
	private Sabor sabor;
	private Estilo estilo;
	private Origem origem;
	private BigDecimal valorDe;
	private BigDecimal valorAte;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public BigDecimal getValorDe() {
		return valorDe;
	}

	public void setValorDe(BigDecimal valorDe) {
		this.valorDe = valorDe;
	}

	public BigDecimal getValorAte() {
		return valorAte;
	}

	public void setValorAte(BigDecimal valorAte) {
		this.valorAte = valorAte;
	}

}
