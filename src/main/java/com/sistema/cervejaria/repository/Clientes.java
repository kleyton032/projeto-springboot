package com.sistema.cervejaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.cervejaria.model.Cliente;

//repositório clientes
@Repository
public interface Clientes extends JpaRepository<Cliente, Long>  {

	
}
