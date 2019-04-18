package br.com.jsfspringboot.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.jsfspringboot.enums.PermissoesEnum;
import br.com.jsfspringboot.repository.UserRepository;

//Executar ações durante o boot

@Configuration
public class Teste {
	
	@Autowired
	private UserRepository repo;
	
	@PostConstruct
	public void postConstruct() {
		for(PermissoesEnum p : PermissoesEnum.listaPermissoes()) {
			System.out.println(p.getValor()+" - "+p.getDescricao()+" - "+p.getUrl());			
		}
	}
	
}
