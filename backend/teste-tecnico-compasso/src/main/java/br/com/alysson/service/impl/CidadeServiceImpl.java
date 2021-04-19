package br.com.alysson.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alysson.entity.Cidade;
import br.com.alysson.repository.CidadeRepository;
import br.com.alysson.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{
	
	private CidadeRepository repository;
	
	@Autowired
	public CidadeServiceImpl(CidadeRepository CidadeRepository) {
		this.repository = CidadeRepository;
	}

	@Override
	public Cidade salvar(Cidade Cidade) {
		return repository.save(Cidade);
	}


	@Override
	public List<Cidade> listarTodos() {
		return repository.findAll();
	}

	@Override
	public Optional<Cidade> obterByID(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deletar(Cidade Cidade) {
		repository.delete(Cidade);
	}

	@Override
	public List<Cidade> listarPorNome(String nome) {
		return repository.findByNomeIgnoreCase(nome);
	}

	@Override
	public List<Cidade> listarPorEstado(String estado) {
		return repository.findByEstadoIgnoreCase(estado);
	}

	

}
