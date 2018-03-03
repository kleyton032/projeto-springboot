package com.sistema.cervejaria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.cervejaria.model.Cliente;
import com.sistema.cervejaria.repository.Clientes;

@Service
public class CadastroClienteService {

	@Autowired
	private Clientes clientes;
	
	@Transactional
	public void salvar(Cliente cliente) {
		clientes.save(cliente);
	}
}
