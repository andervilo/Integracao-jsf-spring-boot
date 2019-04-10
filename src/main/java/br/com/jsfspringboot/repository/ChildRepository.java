package br.com.jsfspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jsfspringboot.dominio.Child;

public interface ChildRepository extends JpaRepository<Child, Long>{

}
