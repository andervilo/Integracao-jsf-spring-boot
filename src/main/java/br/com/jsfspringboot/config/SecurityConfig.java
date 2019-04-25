package br.com.jsfspringboot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.jsfspringboot.dominio.User;
import br.com.jsfspringboot.enums.PermissoesEnum;
import br.com.jsfspringboot.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/index.jsf").permitAll();
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"//colaboradorList.jsf").access("hasRole('ROLE_ADMIN')")
		.antMatchers(HttpMethod.POST,"//colaboradorList.jsf").access("hasRole('ROLE_ADMIN')");
		http.formLogin().permitAll().defaultSuccessUrl("/index.jsf");	
		http.logout().permitAll().logoutSuccessUrl("/login");
		http.csrf().disable();

	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		sincronizarPermissoes();
//		System.out.println("2");
//		for(User user : repo.findAll()) {
//			auth.inMemoryAuthentication().withUser(user.getName()).password(user.getSenha()).roles(user.getRole());
//		}
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
//	@Bean
//	public void sincronizarPermissoes() {
//		System.out.println("1");
//		for(PermissoesEnum p : PermissoesEnum.listaPermissoes()) {
//			System.out.println(p.getValor()+" - "+p.getDescricao()+" - "+p.getUrl());			
//		}
//	}
	
}
