package br.com.jsfspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jsfspringboot.dominio.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{
	public List<Colaborador> findAllByOrderByIdAsc();
	public List<Colaborador> findAllByOrderByIdDesc();
}
