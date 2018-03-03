package com.sistema.cervejaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.cervejaria.model.Cerveja;
import com.sistema.cervejaria.repository.Cervejas;

//classe de serviço para cadastrar a cerveja
@Service
public class CadastroCervejaService {

	//injentando repositório de cerveja
	@Autowired
	private Cervejas cervejas;
	
	//método com transação para cadastrar a cerveja
	@Transactional
	public void salvar(Cerveja cerveja) {
		cervejas.save(cerveja);
	}
	
}
