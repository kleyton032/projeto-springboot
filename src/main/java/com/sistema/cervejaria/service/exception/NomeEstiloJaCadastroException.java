package com.sistema.cervejaria.service.exception;

//verifica se nome estilo já ta cadastrado
public class NomeEstiloJaCadastroException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public NomeEstiloJaCadastroException(String message) {
		
		super(message);
	}
	

	
	
}
