package br.com.jsfspringboot.jsfbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsfspringboot.dominio.Child;
import br.com.jsfspringboot.repository.ChildRepository;

@RestController
@RequestMapping("/api")
public class IndexController {
	
	@Autowired
	private ChildRepository r;

	@GetMapping("/child")
	public List<Child> getListChild(){
		return r.findAll();
	}
	
	@PostMapping("/child")
	public Child save(@RequestBody Child child) {
		return r.saveAndFlush(child);
	}
	
	@GetMapping("/child/{id}")
	public Child getOne(@PathVariable Long id) {
		return r.findById(id).get();
	}
}
