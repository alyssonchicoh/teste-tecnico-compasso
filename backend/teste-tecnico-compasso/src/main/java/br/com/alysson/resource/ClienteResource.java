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

import br.com.alysson.entity.Cliente;
import br.com.alysson.service.ClienteService;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(path = "/salvar")
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		 cliente = clienteService.salvar(cliente);
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}

	
	@GetMapping(path = "/listar")
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> lista = clienteService.listarTodos();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping(path = "/listar_by_nome/{nome}")
	public ResponseEntity<List<Cliente>> listarByNome(@PathVariable String nome){
		List<Cliente> lista = clienteService.listarPorNome(nome);
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/obter_by_id/{id}")
	public ResponseEntity<Optional<Cliente>> obterByID(@PathVariable Integer id){
		Optional<Cliente> cliente;
		
		try {
			cliente = clienteService.obterByID(id);
			return new ResponseEntity<Optional<Cliente>>(cliente,HttpStatus.OK);

		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<Optional<Cliente>>(HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping(path = "/deletar/{id}")
	public ResponseEntity<Optional<Cliente>> deletar(@PathVariable Integer id){
		try {
			
			clienteService.deletar(clienteService.obterByID(id).get());
			return new ResponseEntity<Optional<Cliente>>(HttpStatus.OK);

		}catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<Optional<Cliente>>(HttpStatus.NOT_FOUND);

		}
	}
	
	@PutMapping(path = "/atualizar")
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
		cliente = clienteService.salvar(cliente);
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	
	
	
	
}
