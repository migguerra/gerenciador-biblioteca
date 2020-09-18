package com.biblioteca.gerenciador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class LivroEntity {

	@Id
	@Column(name = "id_livro")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idLivro;

	private String nome;

	private String autor;

	private String editora;

	@OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
	private List<EmprestimoEntity> emprestimos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public List<EmprestimoEntity> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<EmprestimoEntity> emprestimos) {
		this.emprestimos = emprestimos;
	}

}
