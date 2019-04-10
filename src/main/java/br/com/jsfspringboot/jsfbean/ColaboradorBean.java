package br.com.jsfspringboot.jsfbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.jsfspringboot.dominio.Colaborador;
import br.com.jsfspringboot.repository.ColaboradorRepository;

@Scope(value = "session")
@Component(value = "colaboradorBean")
public class ColaboradorBean {
	
	@Autowired
	private ColaboradorRepository repository;
	
	private Colaborador VO = new Colaborador();

	public Colaborador getVO() {
		return VO;
	}

	public void setVO(Colaborador vO) {
		VO = vO;
	}
	
	public List<Colaborador> getListColaborador(){
		return repository.findAllByOrderByIdDesc();
//		return repository.findAll();
		
	}
	
	public void save() {
		//System.out.println(getVO().getNome());
		repository.saveAndFlush(getVO());
		setVO(new Colaborador());
	}
	
	public void delete() {
		//System.out.println(getVO().getNome());
		repository.delete(getVO());
		setVO(new Colaborador());
		//return null;
	}
	
	public void editar(Colaborador colaborador) {
		//System.out.println(getVO().getNome());
		//repository.delete(getVO());
		setVO(colaborador);
		//return null;
	}
	
	
}
