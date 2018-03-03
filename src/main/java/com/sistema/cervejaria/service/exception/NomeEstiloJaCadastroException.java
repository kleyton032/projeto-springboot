package com.sistema.cervejaria.service.exception;

////classe de exceção criada para verificar se nome já ta cadastrado
public class NomeEstiloJaCadastroException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//construtor
	public NomeEstiloJaCadastroException(String message) {
		
		super(message);
	}
	

	
	
}
