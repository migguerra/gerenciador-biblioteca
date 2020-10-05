package com.biblioteca.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.gerenciador.model.UsuarioEntity;

public interface UserRepository extends JpaRepository<UsuarioEntity, Integer>{

	UsuarioEntity findByName(String name);
	
}
