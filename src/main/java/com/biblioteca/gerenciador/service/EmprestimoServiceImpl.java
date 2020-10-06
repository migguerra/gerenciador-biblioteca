package com.biblioteca.gerenciador.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biblioteca.gerenciador.dto.EmprestimoRequestDTO;
import com.biblioteca.gerenciador.dto.EmprestimoResponseDTO;
import com.biblioteca.gerenciador.model.EmprestimoEntity;
import com.biblioteca.gerenciador.model.LivroEntity;
import com.biblioteca.gerenciador.model.UsuarioEntity;
import com.biblioteca.gerenciador.repository.BookRepository;
import com.biblioteca.gerenciador.repository.EmprestimoRepository;
import com.biblioteca.gerenciador.repository.UserRepository;

@Component
public class EmprestimoServiceImpl implements EmprestimoService{

	@Autowired
	private EmprestimoRepository repository;
	
	//chamei o repositorio de livros e de usuario pois um emprestimo precisa de um usuario e um livro
	@Autowired
	private BookRepository repositoryLivro;
	
	@Autowired
	private UserRepository repositoryUser;
		
	
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public EmprestimoResponseDTO createEmprestimo(Integer idUsuario, Integer IdLivro, EmprestimoRequestDTO emprestimo) {
		
		EmprestimoEntity dtoConvertedEmprestimo = mapper.map(emprestimo, EmprestimoEntity.class);
		Optional<UsuarioEntity> findUser = repositoryUser.findById(idUsuario);
		Optional<LivroEntity> findLivro = repositoryLivro.findById(IdLivro);
		
		//associacao //a associação e só na hora de criar/salvar
		dtoConvertedEmprestimo.setUsuario(findUser.get());
		dtoConvertedEmprestimo.setLivro(findLivro.get());
				
		EmprestimoEntity saveEmprestimo = repository.save(dtoConvertedEmprestimo);
		
		EmprestimoResponseDTO convertedEntity = mapper.map(saveEmprestimo, EmprestimoResponseDTO.class);
		
		return convertedEntity;
	}
	
	
	@Override
	public EmprestimoResponseDTO updateEmprestimo(EmprestimoRequestDTO emprestimo) {
		
		EmprestimoEntity dtoConvertedEmprestimo = mapper.map(emprestimo, EmprestimoEntity.class);
		EmprestimoEntity convertedEntity = repository.save(dtoConvertedEmprestimo);
		EmprestimoResponseDTO convertedDto = mapper.map(convertedEntity, EmprestimoResponseDTO.class);
		
		return convertedDto;
	}

	@Override
	public List<EmprestimoResponseDTO> getByIdlivro(Integer idLivro) {
		List<EmprestimoEntity> emprestimoIdLivro = repository.findByLivroIdLivro(idLivro);
		List<EmprestimoResponseDTO> listaEmprestidoLivro = new ArrayList<>();
		
		for(EmprestimoEntity interacao : emprestimoIdLivro) {
			EmprestimoResponseDTO converteEntity = mapper.map(interacao, EmprestimoResponseDTO.class);
			listaEmprestidoLivro.add(converteEntity);
		}
		return listaEmprestidoLivro;
	}

	@Override
	public EmprestimoResponseDTO getByBookName(String name) {
		boolean status = true;
		EmprestimoRepository emprestimoName = repository.findByStatusAndLivroNome(status, name);
		EmprestimoResponseDTO convertedEntity = mapper.map(emprestimoName, EmprestimoResponseDTO.class);
		return convertedEntity;
	}

	@Override
	public List<EmprestimoResponseDTO> getByUser(Integer idUsuario) {
		List<EmprestimoEntity> listaUsuario = repository.findByUsuarioIdUsuario(idUsuario);
		List<EmprestimoResponseDTO> listaEmprestimo = new ArrayList<>();
		
		for (EmprestimoEntity interacao : listaUsuario) {
			
			EmprestimoResponseDTO intercaoConvertida = mapper.map(interacao, EmprestimoResponseDTO.class);
			listaEmprestimo.add(intercaoConvertida);
		}
		
		return listaEmprestimo;
	}

	@Override
	public void deleteEmprestimo(Integer idEmprestimo) {
		
		Optional<EmprestimoEntity> findEmprestimo = repository.findById(idEmprestimo);
		
		EmprestimoEntity emprestimoEntity = findEmprestimo.get();
		
		emprestimoEntity.setStatus(false);
		
		repository.save(emprestimoEntity);
		
	}

}
