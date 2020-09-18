package com.biblioteca.gerenciador.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class EmprestimoEntity {

	@Id
	@Column(name = "id_emprestimo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEmprestimo;

	@Column(name = "data_retirada")
	private Date dataRetirada;

	@Column(name = "data_entrega")
	private Date dataEntrega;

	private boolean renovacao;

	private boolean status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuario;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_livro")
	private LivroEntity livro;

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Boolean getRenovacao() {
		return renovacao;
	}

	public void setRenovacao(Boolean renovacao) {
		this.renovacao = renovacao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public void setRenovacao(boolean renovacao) {
		this.renovacao = renovacao;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public LivroEntity getLivro() {
		return livro;
	}

	public void setLivro(LivroEntity livro) {
		this.livro = livro;
	}

}
