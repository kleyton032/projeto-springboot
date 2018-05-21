package com.sistema.cervejaria.repository.helper.cidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.cervejaria.model.Cidade;
import com.sistema.cervejaria.repository.filter.CidadeFilter;

public interface CidadesQueires {

	Page<Cidade> filtrar(CidadeFilter cidadeFilter, Pageable pageable);
	
}
