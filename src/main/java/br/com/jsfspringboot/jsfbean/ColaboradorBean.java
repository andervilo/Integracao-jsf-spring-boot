package br.com.jsfspringboot.jsfbean;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        
        Integer page = 0;
        Integer size = 3;
        
        if(paramMap.get("page") != null) {        	
        	page = Integer.parseInt( paramMap.get("page"));
        }
        if(paramMap.get("page") != null) {  
        	size = Integer.parseInt( paramMap.get("size"));
        }
        
        System.out.println(repository.count());
        
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAllByOrderByIdDesc(pageable);
//		return repository.findAllByOrderByIdDesc();
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
