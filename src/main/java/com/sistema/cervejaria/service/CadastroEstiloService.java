package com.sistema.cervejaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.cervejaria.model.Estilo;
import com.sistema.cervejaria.repository.Estilos;
import com.sistema.cervejaria.service.exception.NomeEstiloJaCadastroException;

//classe de serviço para cadastrar o estilo
@Service
public class CadastroEstiloService {

	//injentando repositório de estilo
	@Autowired
	private Estilos estilos;
	
	//método com transação para cadastrar o estilo 
	@Transactional
	public void salvar(Estilo estilo) {
		//verificação se o nome já existe cadastrado
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastroException("Nome do estilo já cadastrado");
			
		}
		estilos.save(estilo);
		
	}
}
