package com.biblioteca.gerenciador.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biblioteca.gerenciador.dto.UsuarioDTO;
import com.biblioteca.gerenciador.model.UsuarioEntity;
import com.biblioteca.gerenciador.repository.UserRepository;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UserRepository repository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public UsuarioDTO saveUser(UsuarioDTO usuario) {

		UsuarioEntity dtoConvetedUser = mapper.map(usuario, UsuarioEntity.class);

		UsuarioEntity userSaved = repository.save(dtoConvetedUser);

		UsuarioDTO entityConverted = mapper.map(userSaved, UsuarioDTO.class);

		return entityConverted;

	}

	@Override
	public UsuarioDTO updatedUser(UsuarioDTO usuario) {

		UsuarioEntity dtoConveted = mapper.map(usuario, UsuarioEntity.class);

		UsuarioEntity userUpdated = repository.save(dtoConveted);

		UsuarioDTO entityConverted = mapper.map(userUpdated, UsuarioDTO.class);

		return entityConverted;

	}

	@Override
	public void deleteUser(Integer idUser) {

		repository.deleteById(idUser);

	}

	@Override
	public UsuarioDTO getById(Integer idUser) {

		Optional<UsuarioEntity> findId = repository.findById(idUser);

		if(findId.isEmpty()) {
			return null;
		}
		
		UsuarioDTO entityConverted = mapper.map(findId.get(), UsuarioDTO.class);

		return entityConverted;
	}

	@Override
	public UsuarioDTO getByName(String name) {
		
		UsuarioEntity findName = repository.findByName(name);

		UsuarioDTO entityConverted = mapper.map(findName, UsuarioDTO.class);
		
		return entityConverted;
	}

	
}
