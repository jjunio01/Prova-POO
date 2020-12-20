package com.github.jjunio01.Prova.POO.entities;

/**
 * @author JJunio
 *
 */
public class Poupanca extends Conta {

	private double juros = 0.05;

	public Poupanca(String numero, Banco banco, Cliente cliente, double saldo) {
		super(numero, banco, cliente, saldo);

	}

	public void renderJuros() {
		super.depositar(super.getSaldo() * this.juros);
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

}
