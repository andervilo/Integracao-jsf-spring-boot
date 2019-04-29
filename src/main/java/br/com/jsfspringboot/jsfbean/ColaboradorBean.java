package br.com.jsfspringboot.jsfbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

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
	private Integer size = 0;
	private List<Colaborador> colabList;
	private Page<Colaborador> colabPage;
	private String buscaNome = "";
	private List<SelectItem> porPagina;

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
		teste();
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

	public String getBuscaNome() {
		return buscaNome;
	}

	public void setBuscaNome(String buscaNome) {
		this.buscaNome = buscaNome;
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
			colabPage = repository.findByNomeContainingOrEmailContainingAllIgnoreCase(buscaNome, buscaNome, colabPage.nextPageable());;
			setColabList(colabPage.getContent());
		}
	}
	
	public void anterior() {
		if(colabPage.hasPrevious()) {
			colabPage = repository.findByNomeContainingOrEmailContainingAllIgnoreCase(buscaNome, buscaNome, colabPage.previousPageable());
			setColabList(colabPage.getContent());
		}
	}
	
	public List<SelectItem> getPorPagina(){
		porPagina = new ArrayList<SelectItem>();
		porPagina.add(new SelectItem(new Integer(5),  " 5 Registros por página"));
		porPagina.add(new SelectItem(new Integer(10), "10 Registros por página"));
		porPagina.add(new SelectItem(new Integer(15), "15 Registros por página"));
		porPagina.add(new SelectItem(new Integer(20), "20 Registros por página"));
		return porPagina;
	}
	
	@PostConstruct
	public void initListColaborador(){
		setSize(5);
		Pageable pageable = PageRequest.of(page, size, new Sort(Direction.DESC, "id"));
		colabPage = repository.findByNomeContainingOrEmailContainingAllIgnoreCase(buscaNome, buscaNome, pageable);
		System.out.println(getSize());
		setColabList(colabPage.getContent());
	}
	
	public void listColaborador(){
        System.out.println("chamou: "+buscaNome);
		Pageable pageable = PageRequest.of(page, size, new Sort(Direction.DESC, "id"));
		colabPage = repository.findByNomeContainingOrEmailContainingAllIgnoreCase(buscaNome, buscaNome, pageable);
		
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
