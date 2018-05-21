package com.sistema.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.cervejaria.controller.page.PageWrapper;
import com.sistema.cervejaria.model.Cidade;
import com.sistema.cervejaria.repository.Cidades;
import com.sistema.cervejaria.repository.Estados;
import com.sistema.cervejaria.repository.filter.CidadeFilter;
import com.sistema.cervejaria.service.CadastroCidadeService;
import com.sistema.cervejaria.service.exception.NomeCidadeJaCadastroException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;

@Controller
@RequestMapping("/cidades")
public class CidadesController {

	// injetando repositório de cidades
	@Autowired
	private Cidades cidades;

	@Autowired
	private Estados estados;

	// injetando repositório de serviço
	@Autowired
	private CadastroCidadeService cadastroCidadeService;

	// carregar a tela de cadastro de cidade
	@RequestMapping("/novo")
	public ModelAndView novo(Cidade cidade) {
		ModelAndView mv = new ModelAndView("cidade/CadastroCidade");
		mv.addObject("estados", estados.findAll());
		return mv;
	}

	// cadastro de cidade
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cidade);
		}

		try {
			cadastroCidadeService.salvar(cidade);
		} catch (NomeCidadeJaCadastroException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(cidade);
		}

		attributes.addFlashAttribute("mensagem", "Cidade salva com sucesso!");
		return new ModelAndView("redirect:/cidades/nova");
	}

	// método para carregar o estado no combobox via JSON
	// e retornar lista de cidades quando for selecionado o estado
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Cidade> pesquisarPorCodigoEstado(
			@RequestParam(name = "estado", defaultValue = "-1") Long codigoEstado) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		return cidades.findByEstadoCodigo(codigoEstado);
	}

	// método para pesquisar a cidade
	@GetMapping
	public ModelAndView pesquisar(CidadeFilter cidadeFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("cidade/PesquisaCidade");
		mv.addObject("estados", estados.findAll());
		PageWrapper<Cidade> paginaWrapper = new PageWrapper<>(cidades.filtrar(cidadeFilter, pageable),
				httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}

}
