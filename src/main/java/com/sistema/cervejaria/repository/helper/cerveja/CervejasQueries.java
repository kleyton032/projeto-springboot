package com.sistema.cervejaria.repository.helper.cerveja;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.cervejaria.model.Cerveja;
import com.sistema.cervejaria.repository.filter.CervejaFilter;

//repoitório customizado para filtro da pesquisa
public interface CervejasQueries {
	
	public Page<Cerveja> filtrar(CervejaFilter cervejaFilter, Pageable pageable);

}
