package com.sistema.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuariosController {

	//carrega a página de cadastro de usuários
	@RequestMapping("/usuarios/novo")
	public String novo() {
		return "usuario/CadastroUsuario";
	}
}
