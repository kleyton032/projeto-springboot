package com.sistema.cervejaria.repository.helper.estilo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.cervejaria.model.Estilo;
import com.sistema.cervejaria.repository.filter.EstiloFilter;

public interface EstilosQueries {
	
	public Page<Estilo> filtrar(EstiloFilter estiloFilter, Pageable pageable);

}
