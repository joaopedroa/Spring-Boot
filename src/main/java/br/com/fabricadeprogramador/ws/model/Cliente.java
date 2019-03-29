package br.com.fabricadeprogramador.ws.model;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	private String nome;
	
	@ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Estado estado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
