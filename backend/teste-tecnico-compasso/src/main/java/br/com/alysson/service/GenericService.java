package br.com.alysson.service;

import java.util.List;
import java.util.Optional;


public interface GenericService<T> {

	public T salvar(T obj);
	
	public List<T> listarTodos();
	
	public Optional<T> obterByID(Integer id);
	
	public void deletar(T obj);
}
