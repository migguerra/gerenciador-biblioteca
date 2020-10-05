package com.biblioteca.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.gerenciador.model.LivroEntity;

public interface BookRepository extends JpaRepository<LivroEntity, Integer>{
	LivroEntity findByNome(String nome);
	

}
