package br.com.alysson.resource;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alysson.entity.Cidade;
import br.com.alysson.service.CidadeService;

@RestController
@RequestMapping(path = "/cidade")
public class CidadeResource {

	@Autowired
	private CidadeService cidadeService;
	
	@PostMapping(path = "/salvar")
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade Cidade) {
		Cidade = cidadeService.salvar(Cidade);
		return new ResponseEntity<Cidade>(Cidade,HttpStatus.OK);
	}

	
	@GetMapping(path = "/listar")
	public ResponseEntity<List<Cidade>> listar(){
		List<Cidade> lista = cidadeService.listarTodos();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping(path = "/listar_by_nome/{nome}")
	public ResponseEntity<List<Cidade>> listarByNome(@PathVariable String nome){
		List<Cidade> lista = cidadeService.listarPorNome(nome);
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping(path = "/listar_by_estado/{estado}")
	public ResponseEntity<List<Cidade>> listarByEstado(@PathVariable String estado){
		List<Cidade> lista = cidadeService.listarPorEstado(estado);
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/obter_by_id/{id}")
	public ResponseEntity<Optional<Cidade>> obterByID(@PathVariable Integer id){
		Optional<Cidade> Cidade;
		
		try {
			Cidade = cidadeService.obterByID(id);
			return new ResponseEntity<Optional<Cidade>>(Cidade,HttpStatus.OK);

		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<Optional<Cidade>>(HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping(path = "/deletar/{id}")
	public ResponseEntity<Optional<Cidade>> deletar(@PathVariable Integer id){
		try {
			cidadeService.deletar(cidadeService.obterByID(id).get());
			return new ResponseEntity<Optional<Cidade>>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<Optional<Cidade>>(HttpStatus.NOT_FOUND);

		}
	}
	
	@PutMapping(path = "/atualizar")
	public ResponseEntity<Cidade> atualizar(@RequestBody Cidade Cidade){
		Cidade = cidadeService.salvar(Cidade);
		return new ResponseEntity<Cidade>(Cidade,HttpStatus.OK);
	}
	
	
	
	
}
