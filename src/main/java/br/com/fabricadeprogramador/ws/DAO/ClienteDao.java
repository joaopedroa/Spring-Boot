package br.com.fabricadeprogramador.ws.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.ws.model.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente,Integer> {

}
