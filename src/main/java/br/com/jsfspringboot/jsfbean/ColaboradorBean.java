package br.com.jsfspringboot.jsfbean;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
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
	
	private Integer page = 0;
	private Integer size = 10;
	private List<Colaborador> colabList;

	public Colaborador getVO() {
		return VO;
	}

	public void setVO(Colaborador vO) {
		VO = vO;
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<Colaborador> getColabList() {
		listColaborador();
		return colabList;
	}

	public void setColabList(List<Colaborador> colabList) {
		this.colabList = colabList;
	}
	
	public void teste() {
		System.out.println("page: "+page+" size: "+size);
	}

	public void listColaborador(){
		FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        
        System.out.println("page: "+page+" size: "+size);
        
		Pageable pageable = PageRequest.of(page, size);
		Page<Colaborador> consulta = repository.findAll(pageable);
		
		setColabList(consulta.getContent());
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
