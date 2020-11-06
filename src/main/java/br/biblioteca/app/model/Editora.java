package br.biblioteca.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Editora {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long Id_editora;
	public String nome;
	public String tipo;
	
	
	
	public Long getId_editora() {
		return Id_editora;
	}
	public void setId_editora(Long id_editora) {
		Id_editora = id_editora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	



}