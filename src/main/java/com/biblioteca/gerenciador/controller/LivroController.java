package com.biblioteca.gerenciador.controller;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.gerenciador.dto.LivroDTO;
import com.biblioteca.gerenciador.service.LivroService;

@RestController
@RequestMapping("/api/v1")
public class LivroController {

	@Autowired
	private LivroService service;
	
	
	@GetMapping(value = "/livro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LivroDTO> getLivro(@PathVariable("id") Integer id){
		
		LivroDTO livroDto = service.getByIdlivro(id);
		
		return new ResponseEntity<LivroDTO>(livroDto, HttpStatus.OK);
	}

	@GetMapping(value = "/livro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LivroDTO> getByName(@RequestHeader("name") String name){
		
		LivroDTO userFind = service.getByName(name);
		
		return new ResponseEntity<LivroDTO>(userFind, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/livro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LivroDTO> saveLivro(@RequestBody LivroDTO dto){
	
		LivroDTO savedLivro = service.saveBook(dto);
		
		return new ResponseEntity<LivroDTO>(savedLivro, HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/livro/{id}")
	public ResponseEntity<Void> deletelivro(@PathVariable("id") Integer id){
		
		service.deleteBook(id);
		
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping(value = "/livro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LivroDTO> updatedLivro(@RequestBody LivroDTO bookUpdated){
		
		LivroDTO updatedLivro = service.updateBook(bookUpdated);
		
		return new ResponseEntity<LivroDTO>(updatedLivro, HttpStatus.OK);
		
	}
}	