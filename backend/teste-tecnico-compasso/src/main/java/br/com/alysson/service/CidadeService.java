package br.com.alysson.service;

import java.util.List;
import java.util.Optional;

import br.com.alysson.entity.Cidade;
import br.com.alysson.entity.Cliente;

public interface CidadeService extends GenericService<Cidade>{
	
	public List<Cidade> listarPorNome(String nome);
	
	public List<Cidade> listarPorEstado(String estado);
	
}
