package br.com.fabricadeprogramador.ws.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value= {"/"})
	public String clientes() {
		return "index2.html";
	}
	@RequestMapping(value= {"/cadastroClientes"})
	public String cadastroClientes() {
		return "views/cadastroClientes.html";
	}
}
