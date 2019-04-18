package br.com.jsfspringboot.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.jsfspringboot.dominio.User;
import br.com.jsfspringboot.repository.UserRepository;

//Executar ações durante o boot

@Configuration
public class Teste {
	
	@Autowired
	private UserRepository repo;
	
	@PostConstruct
	public void postConstruct() {
		for(User user : repo.findAll()) {
			System.out.println(user.getName()+"-"+user.getRole());			
		}
	}
	
}
