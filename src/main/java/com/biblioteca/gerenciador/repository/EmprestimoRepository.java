package com.biblioteca.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.gerenciador.model.EmprestimoEntity;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Integer>{

	List<EmprestimoEntity> findByLivroIdLivro(Integer idLivro);
	List<EmprestimoEntity> findByUsuarioIdUsuario(Integer usuario);
	
	EmprestimoRepository findByStatusAndLivroNome(boolean status, String name);
	
	
	
}
