package br.com.jsfspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jsfspringboot.dominio.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
