package com.sistema.cervejaria.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sistema.cervejaria.controller.page.PageWrapper;
import com.sistema.cervejaria.model.Estilo;
import com.sistema.cervejaria.repository.Estilos;
import com.sistema.cervejaria.repository.filter.EstiloFilter;
import com.sistema.cervejaria.service.CadastroEstiloService;
import com.sistema.cervejaria.service.exception.NomeEstiloJaCadastroException;


@Controller
@RequestMapping("/estilos")
public class EstilosController {
	
	//injetando serviço de estilo
	@Autowired
	private CadastroEstiloService cadastroEstiloService;
	
	//injetando repositório de estilo
	@Autowired
	private Estilos estilos;
	
	//carrega a página de cadastro estilo
	@RequestMapping("/novo")
	public ModelAndView novo(Estilo estilo) {
		ModelAndView mv = new ModelAndView("estilo/CadastroEstilo");
		return mv;
	}
	
	//método para cadastrar estilo no bando de dados
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(estilo);
		}

		try {
			// salvando no banco de dados o estilo...
			cadastroEstiloService.salvar(estilo);
		} catch (NomeEstiloJaCadastroException e) {
			//passando o field do valor para rejeição caso já tenha cadastrado
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			//retornando caso a rejeição seja verdadeira
			return novo(estilo);

		}
		attributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso");
		return new ModelAndView("redirect:/estilos/novo");

	}
	
	/*
	//método para cadastro rápido de estilo - *sem funcionar
	@RequestMapping(value = "/estilos", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}
		
		try {
			cadastroEstiloService.salvar(estilo);
		} catch (NomeEstiloJaCadastroException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok(estilo);
	}
	*/
	
	//método para pesquisar estilo utilizando a classe PageWrapper
	@GetMapping
	public ModelAndView pesquisar(EstiloFilter estiloFilter, BindingResult result, @PageableDefault(size=3) Pageable pageable
			, HttpServletRequest httpServletRequest) {
		ModelAndView mv  = new ModelAndView("estilo/PesquisaEstilo");	
		PageWrapper<Estilo> paginaWrapper = new PageWrapper<>(estilos.filtrar(estiloFilter, pageable)
				, httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}
	
	
	
	

}
