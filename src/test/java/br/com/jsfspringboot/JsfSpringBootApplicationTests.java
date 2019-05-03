package br.com.jsfspringboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jsfspringboot.repository.ColaboradorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsfSpringBootApplicationTests {
	@Autowired
	ConversionService conversionService;
	
	@Autowired
	ColaboradorRepository repository;

//	@Test
//	public void contextLoads() {
//		assertNotNull(repository.findAll());
//	}
	
	@Test
	public void teste() {
		assertThat(conversionService.convert("25", Integer.class)).isEqualTo(25);
	}

}
