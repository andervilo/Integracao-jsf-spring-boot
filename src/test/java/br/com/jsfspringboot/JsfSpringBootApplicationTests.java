package br.com.jsfspringboot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jsfspringboot.repository.ColaboradorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsfSpringBootApplicationTests {
	
	@Autowired
	ColaboradorRepository repository;

//	@Test
//	public void contextLoads() {
//		assertNotNull(repository.findAll());
//	}
	
	@Test
	public void testeNull() {
		assertEquals("Foi","Ricardo Fiuzza de Mello", repository.findById(12).get().getNome());
	}

}
