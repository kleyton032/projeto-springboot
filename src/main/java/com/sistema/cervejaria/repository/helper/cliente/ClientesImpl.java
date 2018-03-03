package com.sistema.cervejaria.repository.helper.cliente;

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
import com.sistema.cervejaria.model.Cliente;
import com.sistema.cervejaria.repository.filter.ClienteFilter;

//classe para criação própria de queries, sem uso dos métodos da classe JPArepository
public class ClientesImpl implements ClientesQueries{

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cliente.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		adicionarFiltro(clienteFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, totalRegistro(clienteFilter));
		
		
	}
	
	private Long totalRegistro(ClienteFilter clienteFilter) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cliente.class);
		adicionarFiltro(clienteFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}
		
		
	
	//filtro pesquisa cliente
		private void adicionarFiltro(ClienteFilter clienteFilter, Criteria criteria) {
			if (clienteFilter != null) {
				if (!StringUtils.isEmpty(clienteFilter.getNome())) {
					criteria.add(Restrictions.ilike("nome", clienteFilter.getNome(), MatchMode.ANYWHERE));
				}

				if (!StringUtils.isEmpty(clienteFilter.getCpfOuCnpj())) {
					criteria.add(Restrictions.eq("cpfOuCnpj", clienteFilter.getCpfOuCnpj()));
				}
			}
		}
	
	}

	
	
	
	

