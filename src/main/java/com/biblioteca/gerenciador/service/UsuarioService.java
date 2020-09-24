package com.biblioteca.gerenciador.service;

import com.biblioteca.gerenciador.dto.UsuarioDTO;

public interface UsuarioService {

	public UsuarioDTO saveUser(UsuarioDTO usuario);

	public UsuarioDTO updatedUser(UsuarioDTO usuario);

	public void deleteUser(Integer idUser);

	public UsuarioDTO getById(Integer idUser);

	public UsuarioDTO getByName(String name);

}
