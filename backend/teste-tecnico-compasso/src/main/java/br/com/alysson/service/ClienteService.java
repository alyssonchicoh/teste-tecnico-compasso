package br.com.alysson.service;

import java.util.List;
import java.util.Optional;

import br.com.alysson.entity.Cidade;
import br.com.alysson.entity.Cliente;

public interface ClienteService extends GenericService<Cliente>{
	
	public List<Cliente> listarPorNome(String nome);

}
