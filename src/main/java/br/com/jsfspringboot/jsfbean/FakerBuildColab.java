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
	
	//@PostConstruct
	public void makeColaboradores() {
		Faker faker = new Faker(new Locale("pt-BR"));
		for(int i = 0; i <= 1000; i++ ) {
			Colaborador colab = new Colaborador();
			
			colab.setNome(faker.name().nameWithMiddle());
			colab.setCelular(
					"("+faker.number().digits(2)+") "+faker.number().digits(5)+"-"+faker.number().digits(4)
					);
			colab.setEmail(faker.internet().emailAddress());
			
			
//			ColaboradorDTO colab = new ColaboradorDTO(
//					faker.leagueOfLegends().champion(), 
//					faker.lorem().sentence(3), 
//					faker.phoneNumber().cellPhone(), 
//					faker.address().zipCode(), 
//					faker.lorem().sentence(3), 
//					faker.lorem().sentence(4), 
//					faker.number().digits(11), 
//					faker.internet().emailAddress(), 
//					faker.address().streetAddress(), 
//					faker.address().streetAddressNumber(), 
//					faker.artist().name(), 
//					faker.job().title());
			
			//repository.save(colab);
		}
		
		//System.out.println(colab.toString()); 
	}
}
