package com.biblioteca.gerenciador.service;

import java.util.List;

import com.biblioteca.gerenciador.dto.EmprestimoRequestDTO;
import com.biblioteca.gerenciador.dto.EmprestimoResponseDTO;

public interface EmprestimoService {

	public EmprestimoResponseDTO createEmprestimo(Integer idUsuario, Integer IdLivro, EmprestimoRequestDTO emprestimo);

	public EmprestimoResponseDTO updateEmprestimo(EmprestimoRequestDTO emprestimo);

	public List<EmprestimoResponseDTO> getByIdlivro(Integer idLivro);

	public EmprestimoResponseDTO getByBookName(String name);

	public List<EmprestimoResponseDTO> getByUser(Integer idUsuario);

	public void deleteEmprestimo(Integer idEmprestimo);

}
