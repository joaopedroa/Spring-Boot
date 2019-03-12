package br.com.fabricadeprogramador.ws.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.ws.model.Cliente;
import br.com.fabricadeprogramador.ws.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	//EndPoints
	
	@RequestMapping(method=RequestMethod.POST,value="/clientes",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarcliente(@RequestBody Cliente cliente) {
		
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		
		return new ResponseEntity<>(clienteCadastrado,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/buscarTodosClientes",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> listarTodosClientes() {
		
		Collection<Cliente> clientesListados = clienteService.buscarTodosClientes();
		
		return new ResponseEntity<>(clientesListados,HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/excluirCliente/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id){
		
		Cliente clienteParaExcluir = clienteService.buscarClientePorId(id); 
		
		if(clienteParaExcluir != null) {
			clienteService.excluirCliente(clienteParaExcluir);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/alterarCliente",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarClientes(@RequestBody Cliente cliente){
		
		Cliente clienteParaAlterar = clienteService.buscarClientePorId(cliente.getId()); 
		
		if(clienteParaAlterar != null) {
			Cliente alterado = clienteService.alterarCliente(cliente);
			return new ResponseEntity<>(alterado,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		
	}
}
