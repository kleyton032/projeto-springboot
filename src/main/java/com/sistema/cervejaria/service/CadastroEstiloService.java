package com.sistema.cervejaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.cervejaria.model.Estilo;
import com.sistema.cervejaria.repository.Estilos;
import com.sistema.cervejaria.service.exception.NomeEstiloJaCadastroException;

@Service
public class CadastroEstiloService {

	
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public void salvar(Estilo estilo) {
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastroException("Nome do estilo já cadastrado");
			
		}
		estilos.save(estilo);
		
	}
}
