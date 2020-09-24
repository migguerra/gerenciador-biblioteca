package com.biblioteca.gerenciador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public UsuarioDTO getUsuario(@PathVariable("id") Integer id) {

		return service.getById(id);

	}

}
