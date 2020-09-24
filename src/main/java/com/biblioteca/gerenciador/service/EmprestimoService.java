package com.biblioteca.gerenciador.service;

import com.biblioteca.gerenciador.dto.EmprestimoRequestDTO;
import com.biblioteca.gerenciador.dto.EmprestimoResponseDTO;

public interface EmprestimoService {

	public EmprestimoResponseDTO createEmprestimo(Integer idUsuario, Integer IdLivro, EmprestimoRequestDTO emprestimo);

	public EmprestimoResponseDTO updateEmprestimo(EmprestimoRequestDTO emprestimo);

	public EmprestimoResponseDTO getByIdlivro(Integer idLivro);

	public EmprestimoResponseDTO getByBookName(String name);

	public EmprestimoResponseDTO getByUser(Integer idUsuario);

	public void deleteEmprestimo(Integer idEmprestimo);

}
