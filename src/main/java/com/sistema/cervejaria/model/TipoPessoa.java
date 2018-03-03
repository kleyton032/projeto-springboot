package com.sistema.cervejaria.model;

import com.sistema.cervejaria.model.validation.group.CnpjGroup;
import com.sistema.cervejaria.model.validation.group.CpfGroup;

public enum TipoPessoa {

	FISICA("Física", "CPF", "000.000.000-00", CpfGroup.class), 
	JURIDICA("Jurídica", "CNPJ", "00.000.000/0000-00", CnpjGroup.class);

	private String descricao;
	private String documento;
	private String mascara;
	private Class<?> grupo;

	private TipoPessoa(String descricao, String documento, String mascara, Class<?> grupo) {
		this.descricao = descricao;
		this.documento = documento;
		this.mascara = mascara;
		this.grupo = grupo; 
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}
	public Class<?> getGrupo() {
		return grupo;
	}

}
