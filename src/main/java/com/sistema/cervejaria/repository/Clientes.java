package com.sistema.cervejaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.cervejaria.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long>  {

	
}
