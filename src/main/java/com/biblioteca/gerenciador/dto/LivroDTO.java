package com.biblioteca.gerenciador.dto;

import java.io.Serializable;

public class LivroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idLivro;

	private String autor;

	private String editora;

	private String nome;

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
