package br.com.jsfspringboot.jsfbean;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

import br.com.jsfspringboot.dominio.Colaborador;
import br.com.jsfspringboot.repository.ColaboradorRepository;

//@Configuration
public class FakerBuildColab {
	
	@Autowired
	private ColaboradorRepository repository;
	
	@PostConstruct
	public void makeColaboradores() {
		Faker faker = new Faker(new Locale("pt-BR"));
		for(int i = 0; i <= 1000; i++ ) {
			Colaborador colab = new Colaborador();
			
			colab.setNome(faker.name().nameWithMiddle());
			colab.setCelular(
					"("+faker.number().digits(2)+") "+faker.number().digits(5)+"-"+faker.number().digits(4)
					);
			colab.setEmail(faker.internet().emailAddress());
			
			
			repository.save(colab);
		}
		 
	}
}
