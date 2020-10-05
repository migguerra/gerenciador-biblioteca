package com.biblioteca.gerenciador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorDeBibliotecaApplication {

	public static void main(String[] args) {
		
		
		Gato gato = new Gato();
		
		 String baraulho =  gato.barulho();
		
		 Dono dono = gato.cuidador();
		
		 System.out.println(dono.getNome());
		 
		SpringApplication.run(GerenciadorDeBibliotecaApplication.class, args);
		

		
	}

}
