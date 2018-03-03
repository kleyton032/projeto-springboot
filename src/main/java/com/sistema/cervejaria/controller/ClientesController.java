package com.sistema.cervejaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.cervejaria.model.Cliente;
import com.sistema.cervejaria.model.TipoPessoa;
import com.sistema.cervejaria.repository.Estados;
import com.sistema.cervejaria.service.CadastroClienteService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	//injetando repositorio estados
	@Autowired
	private Estados estados;
	
	//injetando a classe de serviço
	@Autowired
	private CadastroClienteService cadastroClienteService;
	
//	@Autowired
//	private Clientes clientes;
	

	//carregando página de cliente
	@RequestMapping("/novo")
	public ModelAndView novo(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tiposPessoa", TipoPessoa.values());
		mv.addObject("estados", estados.findAll());
		return mv;
	}
	
	//salvando cliente
	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid Cliente cliente, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cliente);
		}
		cadastroClienteService.salvar(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		return new ModelAndView("redirect:/clientes/novo");

	}
	
}
