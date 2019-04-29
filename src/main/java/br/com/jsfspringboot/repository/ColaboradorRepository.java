package br.com.jsfspringboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jsfspringboot.dominio.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{
	public List<Colaborador> findAllByOrderByIdAsc();
	public List<Colaborador> findAllByOrderByIdDesc();
	public List<Colaborador> findAllByOrderByIdDesc(Pageable pageable);
//	Page<Colaborador> findByNomeIgnoreCaseContainingOrEmailIgnoreCaseContaining(String nome, String email, Pageable pageable);
	Page<Colaborador> findByNomeContainingOrEmailContainingAllIgnoreCase(String nome, String email, Pageable pageable);
	
}
