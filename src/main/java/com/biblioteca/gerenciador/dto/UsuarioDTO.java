package com.biblioteca.gerenciador.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "id")
	private Integer idUsuario;

	private String email;

	private String senha;

	@JsonProperty(value = "quantidade-livros")
	private int quantidadeLivros;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getQuantidadeLivros() {
		return quantidadeLivros;
	}

	public void setQuantidadeLivros(int quantidadeLivros) {
		this.quantidadeLivros = quantidadeLivros;
	}

}
