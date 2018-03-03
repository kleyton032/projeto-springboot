package com.sistema.cervejaria.repository.helper.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.cervejaria.model.Cliente;
import com.sistema.cervejaria.repository.filter.ClienteFilter;

//repoitório customizado para filtro da pesquisa de clientes
public interface ClientesQueries {

	public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
	
	
}
