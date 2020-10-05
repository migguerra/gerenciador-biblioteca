package com.biblioteca.gerenciador.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biblioteca.gerenciador.dto.LivroDTO;
import com.biblioteca.gerenciador.model.LivroEntity;
import com.biblioteca.gerenciador.repository.BookRepository;

@Component
public class LivroServiveImpl implements LivroService {

	@Autowired
	private BookRepository repository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public LivroDTO saveBook(LivroDTO livro) {

		LivroEntity dtoConvetedLivro = mapper.map(livro, LivroEntity.class);

		LivroEntity saveBook = repository.save(dtoConvetedLivro);

		LivroDTO entityConverted = mapper.map(saveBook, LivroDTO.class);

		return entityConverted;
	}

	@Override
	public LivroDTO updateBook(LivroDTO livro) {

		LivroEntity dtoConvertedLivro = mapper.map(livro, LivroEntity.class);

		LivroEntity livroUpdated = repository.save(dtoConvertedLivro);

		LivroDTO entityConverted = mapper.map(livroUpdated, LivroDTO.class);

		return entityConverted;
	}

	@Override
	public void deleteBook(Integer IdLivro) {
		repository.deleteById(IdLivro);
	}

	@Override
	// vai direto para o repositorio pois o tipo (integer) é o mesmo

	public LivroDTO getByIdlivro(Integer idLivro) {

		Optional<LivroEntity> findId = repository.findById(idLivro);

		LivroDTO entityConverted = mapper.map(findId.get(), LivroDTO.class);

		return entityConverted;
	}

	@Override
	public LivroDTO getByName(String name) {
		
		LivroEntity findName = repository.findByNome(name);
		
		LivroDTO entityConverted = mapper.map(findName, LivroDTO.class);
		
		return entityConverted;
	}

}
