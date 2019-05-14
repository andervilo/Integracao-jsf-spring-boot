package br.com.jsfspringboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jsfspringboot.dominio.Colaborador;
import br.com.jsfspringboot.repository.ColaboradorRepository;

//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JsfSpringBootApplicationTests {
	@Autowired
	ConversionService conversionService;
	
//	@Autowired
	@Mock
	ColaboradorRepository repository;
	
	@Mock
	ColaboradorService colaboradorService;

//	@Test
//	public void contextLoads() {
//		assertNotNull(repository.findAll());
//	}
	
	@Test
	public void teste() {
		Colaborador colaborador = new Colaborador();
		colaborador.setNome("Carlos Bastos");
		when(repository.getOne(1)).thenReturn(colaborador);
		
		assertEquals("Carlos Basto", repository.getOne(1).getNome());
	}

}
