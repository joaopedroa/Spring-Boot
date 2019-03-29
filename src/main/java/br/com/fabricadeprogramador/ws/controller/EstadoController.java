package br.com.fabricadeprogramador.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fabricadeprogramador.ws.DAO.EstadoDAO;
import br.com.fabricadeprogramador.ws.model.Estado;
import br.com.fabricadeprogramador.ws.service.EstadoService;


@Controller
public class EstadoController {
	
	@Autowired
	EstadoService estadoService;

	@RequestMapping(method=RequestMethod.POST,value="/salvarEstado",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> salvarEstado(@RequestBody Estado estado){
		
		Estado estadoCadastrado = estadoService.salvarEstado(estado);
		
		return new ResponseEntity<>(estadoCadastrado,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/buscarTodosEstados",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estado>> buscarTodosEstados(){
		
		List<Estado> todosEstados = estadoService.findAllEstados();
		
		return new ResponseEntity<>(todosEstados,HttpStatus.OK);
	}
	
	
}
