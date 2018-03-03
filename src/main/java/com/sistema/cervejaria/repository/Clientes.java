package com.sistema.cervejaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.cervejaria.model.Cliente;

//repositório clientes
@Repository
public interface Clientes extends JpaRepository<Cliente, Long>  {

	 public Optional<Cliente> findBycpfOuCnpj(String cpfOuCnpj);
	
}
