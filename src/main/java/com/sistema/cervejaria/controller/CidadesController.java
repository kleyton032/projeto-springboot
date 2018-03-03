package com.sistema.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sistema.cervejaria.model.Cidade;
import com.sistema.cervejaria.repository.Cidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;


@Controller
@RequestMapping("/cidades")
public class CidadesController {
	
	//injetando repositório de cidades
	@Autowired
	private Cidades cidades;

	//carregar a tela de cadastro de cidade
	@RequestMapping("/novo")
	public String novo() {
		return "cidade/CadastroCidade";
	}
	
	//método para carregar o estado no combobox via JSON 
	//e retornar lista de cidades quando for selecionado o estado
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Cidade> pesquisarPorCodigoEstado(
			@RequestParam(name = "estado", defaultValue = "-1") Long codigoEstado) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {	}
		return cidades.findByEstadoCodigo(codigoEstado);
	}
}
