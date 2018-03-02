package com.sistema.cervejaria.repository.helper.estilo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.sistema.cervejaria.model.Estilo;
import com.sistema.cervejaria.repository.filter.EstiloFilter;

public class EstilosImpl implements EstilosQueries {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Estilo> filtrar(EstiloFilter estiloFilter, Pageable pageable) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Estilo.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		adicionarFiltro(estiloFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, totalRegistro(estiloFilter));
	}

	private Long totalRegistro(EstiloFilter estiloFiltro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Estilo.class);
		adicionarFiltro(estiloFiltro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(EstiloFilter estiloFiltro, Criteria criteria) {
		if (estiloFiltro != null) {
			if (!StringUtils.isEmpty(estiloFiltro.getCodigo())) {
				criteria.add(Restrictions.eq("codigo", estiloFiltro.getCodigo()));
			}

			if (!StringUtils.isEmpty(estiloFiltro.getNome())) {
				criteria.add(Restrictions.ilike("nome", estiloFiltro.getNome(), MatchMode.ANYWHERE));
			}
		}
	}

}
