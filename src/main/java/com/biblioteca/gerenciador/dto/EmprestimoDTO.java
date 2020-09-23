package com.biblioteca.gerenciador.dto;

import java.io.Serializable;
import java.util.Date;

public class EmprestimoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idEmprestimo;

	private Date dataRetirada;

	private Date dataEntrega;

	private boolean renovacao;

	private boolean stutus;

	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

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

	public boolean isRenovacao() {
		return renovacao;
	}

	public void setRenovacao(boolean renovacao) {
		this.renovacao = renovacao;
	}

	public boolean isStutus() {
		return stutus;
	}

	public void setStutus(boolean stutus) {
		this.stutus = stutus;
	}

}
