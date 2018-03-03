package com.sistema.cervejaria.service.exception;

//classe de exceção criada para verificar se cpf já está cadastrado
public class ClienteCpfouCnpjJaCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//construtor
	public ClienteCpfouCnpjJaCadastradoException(String message) {
		super(message);
	
	}

}
