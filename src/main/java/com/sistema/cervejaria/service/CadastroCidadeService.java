package com.sistema.cervejaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.cervejaria.model.Cidade;
import com.sistema.cervejaria.repository.Cidades;
import com.sistema.cervejaria.service.exception.NomeCidadeJaCadastroException;


//classe de serviço de cidade
@Service
public class CadastroCidadeService {

	@Autowired
	private Cidades cidades;

	// método que salva cidade
	@Transactional
	public void salvar(Cidade cidade) {
		//verificando antes de salvar se o nome já existe
		Optional<Cidade> cidadeOptional = cidades.findByNomeAndEstado(cidade.getNome(), cidade.getEstado());
		if (cidadeOptional.isPresent()) {
			throw new NomeCidadeJaCadastroException("Nome da cidade já cadastrado");
		}
		cidades.save(cidade);
	}

}
