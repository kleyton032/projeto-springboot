package com.sistema.cervejaria.repository.helper.cerveja;

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
import com.sistema.cervejaria.model.Cerveja;
import com.sistema.cervejaria.repository.filter.CervejaFilter;

//classe para criação própria de queries, sem uso dos métodos da classe JPArepository
public class CervejasImpl implements CervejasQueries {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Cerveja> filtrar(CervejaFilter cervejaFiltro, Pageable pageable) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		adicionarFiltro(cervejaFiltro, criteria);

		return new PageImpl<>(criteria.list(), pageable, totalRegistro(cervejaFiltro));
	}

	private Long totalRegistro(CervejaFilter cervejaFiltro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class);
		adicionarFiltro(cervejaFiltro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	//filtro pesquisa cerveja
	private void adicionarFiltro(CervejaFilter cervejaFiltro, Criteria criteria) {
		if (cervejaFiltro != null) {
			if (!StringUtils.isEmpty(cervejaFiltro.getSku())) {
				criteria.add(Restrictions.eq("sku", cervejaFiltro.getSku()));
			}

			if (!StringUtils.isEmpty(cervejaFiltro.getNome())) {
				criteria.add(Restrictions.ilike("nome", cervejaFiltro.getNome(), MatchMode.ANYWHERE));
			}

			if (isEstiloPresente(cervejaFiltro)) {
				criteria.add(Restrictions.eq("estilo", cervejaFiltro.getEstilo()));
			}

			if (cervejaFiltro.getSabor() != null) {
				criteria.add(Restrictions.eq("sabor", cervejaFiltro.getSabor()));
			}

			if (cervejaFiltro.getOrigem() != null) {
				criteria.add(Restrictions.eq("origem", cervejaFiltro.getOrigem()));
			}

			if (cervejaFiltro.getValorDe() != null) {
				criteria.add(Restrictions.ge("valor", cervejaFiltro.getValorDe()));
			}

			if (cervejaFiltro.getValorAte() != null) {
				criteria.add(Restrictions.le("valor", cervejaFiltro.getValorAte()));
			}
		}
	}

	private boolean isEstiloPresente(CervejaFilter filtro) {
		return filtro.getEstilo() != null && filtro.getEstilo().getCodigo() != null;
	}

}
