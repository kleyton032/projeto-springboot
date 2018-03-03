package com.sistema.cervejaria.model.validation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.sistema.cervejaria.model.Cliente;

//classe para validação de cpf e cnpj por grupos definidos na classe model cliente
public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<Cliente> {

	@Override
	public List<Class<?>> getValidationGroups(Cliente cliente) {
		List<Class<?>> grupos = new ArrayList<>();
		grupos.add(Cliente.class);
		
		if (isPessoaSelecionada(cliente)) {
			grupos.add(cliente.getTipoPessoa().getGrupo());
		}
		
		return grupos;
	}

	private boolean isPessoaSelecionada(Cliente cliente) {
		return cliente != null && cliente.getTipoPessoa() != null;
	}

}
