package br.com.alysson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.alysson.entity.Cidade;

@Repository
public interface CidadeRepository  extends JpaRepository<Cidade, Integer>{

	public List<Cidade> findByNomeIgnoreCase(String nome);
	
	public List<Cidade> findByEstadoIgnoreCase(String nome);

}
