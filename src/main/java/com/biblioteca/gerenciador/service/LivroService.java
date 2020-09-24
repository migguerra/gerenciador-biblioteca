package com.biblioteca.gerenciador.service;

import com.biblioteca.gerenciador.dto.LivroDTO;

public interface LivroService {

	public LivroDTO savebook(LivroDTO livro);

	public LivroDTO updateBook(LivroDTO livro);

	public void deleteBook(Integer IdLivro);

	public LivroDTO getByIdlivro(Integer idLivro);

	public LivroDTO getByName(String name);

}
