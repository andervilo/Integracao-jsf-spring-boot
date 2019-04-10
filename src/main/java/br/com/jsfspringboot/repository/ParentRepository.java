package br.com.jsfspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jsfspringboot.dominio.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer>{
	
}
