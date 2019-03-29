package br.com.fabricadeprogramador.ws.DAO;

import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.ws.model.Estado;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstadoDAO extends JpaRepository<Estado,Integer> {

}
