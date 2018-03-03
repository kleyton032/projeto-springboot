package com.sistema.cervejaria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.cervejaria.model.Cliente;
import com.sistema.cervejaria.repository.Clientes;

//classe de serviço para cadastrar o cliente
@Service
public class CadastroClienteService {

	//injentando repositório de clientes
	@Autowired
	private Clientes clientes;
	
	//método com transação para cadastrar o cliente
	@Transactional
	public void salvar(Cliente cliente) {
		clientes.save(cliente);
	}
}
