package com.sistema.cervejaria.controller.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.util.UriComponentsBuilder;
//classe para paginação dinâmica e filtro de pesquisa
public class PageWrapper<T> {
	
	
	private Page<T> page;
	//manter a string no filtro da pesquisa passando HttpServletRequest
	private UriComponentsBuilder uriBuilder;

	public PageWrapper(Page<T> page, HttpServletRequest httpServletRequest) {
		//retornando no construtuor a variável para retornar o serviço
//		this.uriBuilder = ServletUriComponentsBuilder.fromRequest(httpServletRequest);
		this.page = page;
		//para corrigir bug da pesquisa quando dava espaço no nome
		String url = httpServletRequest.getRequestURL().append(
		httpServletRequest.getQueryString() !=null ? "?" + httpServletRequest.getQueryString() :"")
		.toString().replaceAll("\\+", "%20");
		this.uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
		
	}
	
	public List<T> getConteudo(){
		return page.getContent();
	}
	
	public boolean isVazia() {
		return page.getContent().isEmpty();
	}
	
	public int getAtual() {
		return page.getNumber();
	}
	
	public boolean isPrimeira() {
		return page.isFirst();
	}
	public boolean isUltima() {
		return page.isLast();
	}
	
	public int getTotal() {
		return page.getTotalPages();
	}
	
	//metodo para passar url com a quantidade de paginas
	public String urlParaPagina(int pagina) {
		return uriBuilder.replaceQueryParam("page", pagina).build(true).encode().toUriString(); 
		
	}

}
