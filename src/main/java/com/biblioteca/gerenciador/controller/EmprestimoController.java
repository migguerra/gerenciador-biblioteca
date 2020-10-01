package com.biblioteca.gerenciador.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.biblioteca.gerenciador.dto.EmprestimoRequestDTO;
import com.biblioteca.gerenciador.dto.EmprestimoResponseDTO;
import com.biblioteca.gerenciador.service.EmprestimoService;

public class EmprestimoController {
	
	@Autowired
	private EmprestimoService service;
	
	@GetMapping(value = "/emprestimo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmprestimoResponseDTO>> getEmprestimoByBookId (@PathVariable ("id") Integer idBook){
		
		List<EmprestimoResponseDTO> listEmprestimo = service.getByIdlivro(idBook);
		
		return new ResponseEntity<List<EmprestimoResponseDTO>>(listEmprestimo, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/emprestimo/{bookName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmprestimoResponseDTO> getEmprestimoByUser (@PathVariable ("bookName") String nomeLivro){
		
		EmprestimoResponseDTO emprestimoDto = service.getByBookName(nomeLivro);
		
		return new ResponseEntity<EmprestimoResponseDTO>(emprestimoDto, HttpStatus.OK);
		
	}
 		
	@GetMapping(value = "/emprestimo/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmprestimoResponseDTO>> getEmprestimoByUser (@PathVariable ("idUser") Integer idUser){
		
		List<EmprestimoResponseDTO> emprestimoDto = service.getByUser(idUser);
		
		return new ResponseEntity<List<EmprestimoResponseDTO>>(emprestimoDto, HttpStatus.OK);
		
	}

	@DeleteMapping(value = "/emprestimo/{idUser}")
	public ResponseEntity<Void> deleteEmprestimo (@PathVariable("idEmprestimo") Integer idEmprestimo){
		
		service.deleteEmprestimo(idEmprestimo);
		
		return ResponseEntity.ok().build(); 
		
	}
	
 	@PostMapping(value = "/emprestimo/{idUser}/{idBook}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmprestimoResponseDTO> saveEmprestimo (@PathVariable("idUser") Integer idUser, @PathVariable("idBook") Integer idBook, @RequestBody EmprestimoRequestDTO emprestimo){
		
		EmprestimoResponseDTO emprestimoSaved = service.createEmprestimo(idUser, idBook, emprestimo);
		
		return new ResponseEntity<EmprestimoResponseDTO>(emprestimoSaved, HttpStatus.CREATED);
		
	}
 	
 	@PutMapping(value = "/emprestimo/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmprestimoResponseDTO> updatedEmprestimo(@RequestBody EmprestimoRequestDTO emprestimoUpdated){
			
		EmprestimoResponseDTO updatedEmprestimo = service.updateEmprestimo(emprestimoUpdated);
			
		return new ResponseEntity<EmprestimoResponseDTO>(updatedEmprestimo, HttpStatus.OK);	
			
		}
				

	
	
}
