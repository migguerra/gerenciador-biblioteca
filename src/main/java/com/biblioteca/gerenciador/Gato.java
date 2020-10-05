package com.biblioteca.gerenciador;

public class Gato implements Animal{

	public String miado = "miau";
	public int patas = 4;
	
	@Override
	public String barulho() {
		return this.miado;
	}
	@Override
	public int numeroPatas() {
		// TODO Auto-generated method stub
		return this.patas;
	}
	
	@Override
	public Dono cuidador() {
		//encapsulamento tipo nome = construtor
		
		Dono dono  = new Dono("clara");
		
		return dono;
	}
	
	
	
}
