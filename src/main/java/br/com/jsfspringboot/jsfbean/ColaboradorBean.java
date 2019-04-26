package br.com.jsfspringboot.jsfbean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	private Integer size = 5;
	private List<Colaborador> colabList;
	Page<Colaborador> colabPage;

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
		return colabList;
	}

	public void setColabList(List<Colaborador> colabList) {
		this.colabList = colabList;
	}
	
	public void teste() {
		System.out.println("page: "+page+" size: "+size);
	}	

	public Page<Colaborador> getColabPage() {
		return colabPage;
	}
	
	

	public void setColabPage(Page<Colaborador> colabPage) {
		this.colabPage = colabPage;
	}

	/**
	 * Comportamentos
	 */
	
	public Integer getPaginaAtual() {
		return getColabPage().getNumber() + 1;
	}
	
	public void proximo() {
		System.out.println(colabPage.getTotalPages());
		if(colabPage.hasNext()) {
			colabPage = repository.findAll(colabPage.nextPageable());
			setColabList(colabPage.getContent());
		}
	}
	
	public void anterior() {
		if(colabPage.hasPrevious()) {
			colabPage = repository.findAll(colabPage.previousPageable());
			setColabList(colabPage.getContent());
		}
	}
	
	@PostConstruct
	public void initListColaborador(){
        
		Pageable pageable = PageRequest.of(page, size, new Sort(Direction.DESC, "id"));
		colabPage = repository.findAll(pageable);
		
		setColabList(colabPage.getContent());
	}
	
	public void listColaborador(){
        
		Pageable pageable = PageRequest.of(page, size, new Sort(Direction.DESC, "id"));
		colabPage = repository.findAll(pageable);
		
		setColabList(colabPage.getContent());
	}
	
	public void save() {
		repository.saveAndFlush(getVO());
		setVO(new Colaborador());
		Pageable pageable = PageRequest.of(colabPage.getNumber(), colabPage.getSize(), new Sort(Direction.DESC, "id"));
		colabPage = repository.findAll(pageable);		
		setColabList(colabPage.getContent());
	}
	
	public void delete() {
		repository.delete(getVO());
		setVO(new Colaborador());
		Pageable pageable = PageRequest.of(colabPage.getNumber(), colabPage.getSize(), new Sort(Direction.DESC, "id"));
		colabPage = repository.findAll(pageable);		
		setColabList(colabPage.getContent());
	}
	
	public void editar(Colaborador colaborador) {
		//System.out.println(getVO().getNome());
		//repository.delete(getVO());
		setVO(colaborador);
		//return null;
	}
	
	
}
