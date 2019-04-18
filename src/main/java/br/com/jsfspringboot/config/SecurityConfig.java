package br.com.jsfspringboot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.jsfspringboot.dominio.User;
import br.com.jsfspringboot.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("//colaboradorList.jsf").access("hasRole('ROLE_ADMIN')").
		and().formLogin().  //login configuration
                //loginPage("/customLogin.xhtml").
                //loginProcessingUrl("/appLogin").
                //usernameParameter("app_username").
                //passwordParameter("app_password").
                defaultSuccessUrl("/colaboradorList.jsf").	
		and().logout().    //logout configuration
		//logoutUrl("/appLogout"). 
		logoutSuccessUrl("/login");

	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		for(User user : repo.findAll()) {
			auth.inMemoryAuthentication().withUser(user.getName()).password(user.getSenha()).roles(user.getRole());
		}
//		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
		
		List<String> list = new ArrayList<String>();
		list.add("ADMIN");
		list.add("USER");
		list.add("TESTER");
		list.add("CODER");
		
		//System.out.println(list.toArray());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
