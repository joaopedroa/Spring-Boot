package br.com.fabricadeprogramador.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.ws.DAO.EstadoDAO;
import br.com.fabricadeprogramador.ws.model.Estado;

@Service
public class EstadoService {
	
	@Autowired
	EstadoDAO estadoDao;
	
	public Estado salvarEstado(Estado estado) {
		return estadoDao.save(estado);
	}
	
	public List<Estado> findAllEstados(){
		return estadoDao.findAll();
	}
}
