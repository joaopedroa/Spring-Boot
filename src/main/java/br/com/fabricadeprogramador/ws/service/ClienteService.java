package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.ws.DAO.ClienteDao;
import br.com.fabricadeprogramador.ws.model.Cliente;

@Service
public class ClienteService {

	@Autowired
	ClienteDao clienteDao;
	
	public Cliente cadastrar(Cliente cliente) {
		
		return clienteDao.save(cliente);
	}
	
	public Collection<Cliente> buscarTodosClientes(){
		
		return clienteDao.findAll();
		
	}
	
	public void excluirCliente(Cliente cliente) {
		clienteDao.delete(cliente);
	}
	
	public Cliente buscarClientePorId(Integer id) {
		return clienteDao.findById(id).get();
	}
	
	public Cliente alterarCliente(Cliente cliente) {
		
		return clienteDao.save(cliente);
	}
	
}
