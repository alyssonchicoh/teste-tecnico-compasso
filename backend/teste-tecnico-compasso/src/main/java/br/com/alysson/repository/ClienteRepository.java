package br.com.alysson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alysson.entity.Cidade;
import br.com.alysson.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	public List<Cliente> findByNomeIgnoreCase(String nome);

}
