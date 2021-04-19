package br.com.alysson.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alysson.entity.Cliente;
import br.com.alysson.repository.ClienteRepository;
import br.com.alysson.service.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService{
	
	private ClienteRepository repository;
	
	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.repository = clienteRepository;
	}

	@Override
	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
	}


	@Override
	public List<Cliente> listarTodos() {
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> obterByID(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deletar(Cliente cliente) {
		repository.delete(cliente);
	}

	@Override
	public List<Cliente> listarPorNome(String nome) {
		return repository.findByNomeIgnoreCase(nome);
	}

	

}
