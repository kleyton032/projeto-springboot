package com.sistema.cervejaria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.cervejaria.model.Cidade;
import com.sistema.cervejaria.model.Estado;

//repositório cidades
@Repository
public interface Cidades extends JpaRepository<Cidade, Long>{

	//metedo para trazer a lista de cidades quando o estado é selecionado
	public List<Cidade> findByEstadoCodigo(Long codigoEstado);
	
	//método para verificar se a cidade já está cadastrada no estado
	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
}
