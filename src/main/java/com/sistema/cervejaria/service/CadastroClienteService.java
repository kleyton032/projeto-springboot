package com.sistema.cervejaria.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.cervejaria.model.Cliente;
import com.sistema.cervejaria.repository.Clientes;
import com.sistema.cervejaria.service.exception.ClienteCpfouCnpjJaCadastradoException;

//classe de serviço para cadastrar o cliente
@Service
public class CadastroClienteService {

	//injentando repositório de clientes
	@Autowired
	private Clientes clientes;
	
	//método com transação para cadastrar o cliente
	@Transactional
	public void salvar(Cliente cliente) {
		//verificação se cpf ou cnpj já está cadastrado
		Optional<Cliente> clienteExiste = clientes.findBycpfOuCnpj(cliente.getCpfOuCnpjSemFormatacao());
		if(clienteExiste.isPresent()) {
			throw new ClienteCpfouCnpjJaCadastradoException("CPF/CNPJ já cadastrado.");
		}
		clientes.save(cliente);
	}
}
