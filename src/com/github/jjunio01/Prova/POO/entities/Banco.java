package com.github.jjunio01.Prova.POO.entities;

/**
 * @author JJunio
 *
 */
public class Banco {

	private String numero;
	private String nome;

	public Banco(String numero, String nome) {
		this.numero = "JJBank: " + numero;
		this.nome = "JJBank: " + nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
