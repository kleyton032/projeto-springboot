package com.sistema.cervejaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.cervejaria.model.Cidade;

public interface Cidades extends JpaRepository<Cidade, Long>{

	public List<Cidade> findByEstadoCodigo(Long codigoEstado);
}
