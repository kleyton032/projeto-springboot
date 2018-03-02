package com.sistema.cervejaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.cervejaria.model.Estilo;
import com.sistema.cervejaria.repository.helper.estilo.EstilosQueries;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long>, EstilosQueries{

	//transação p/verificar se nome do estilo já existe cadastrado...
	public Optional<Estilo> findByNomeIgnoreCase(String nome);
	
}
