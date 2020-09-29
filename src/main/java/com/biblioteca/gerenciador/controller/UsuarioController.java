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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.gerenciador.dto.UsuarioDTO;
import com.biblioteca.gerenciador.service.UsuarioService;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping(value = "/usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable("id") Integer id) {

		UsuarioDTO usuarioDto = service.getById(id);
		
		return new ResponseEntity<UsuarioDTO>(usuarioDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/usuario/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioDTO> getByName(@PathVariable("name") String name){
		
		UsuarioDTO userFind = service.getByName(name);
		
		return new ResponseEntity<UsuarioDTO>(userFind, HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioDTO> saveUser(@RequestBody UsuarioDTO dto){
		
		UsuarioDTO userSaved = service.saveUser(dto);
		
		return new ResponseEntity<UsuarioDTO>(userSaved, HttpStatus.CREATED);
		
	}
	@DeleteMapping(value = "/usuario/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id){
		
		service.deleteUser(id);
		
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioDTO> updatedUser(@RequestBody UsuarioDTO userUpdated){
		
		UsuarioDTO updatedUser = service.updatedUser(userUpdated);
		
		return new ResponseEntity<UsuarioDTO>(updatedUser, HttpStatus.OK);
	}
}
