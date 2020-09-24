package com.biblioteca.gerenciador.dto;

import java.io.Serializable;
import java.util.Date;

public class EmprestimoRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date dataRetirada;

	private boolean renovacao;

	private boolean stutus;

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
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
