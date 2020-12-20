package com.github.jjunio01.Prova.POO.entities;

import java.text.NumberFormat;

/**
 * @author JJunio
 *
 */
public class Conta {

	private String numero;
	private Banco banco;
	private Cliente cliente;
	private double saldo;

	public Conta(String numero, Banco banco, Cliente cliente, double saldo) {
		this.numero = numero;
		this.banco = banco;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositar(double valorDepositado) {
		this.saldo += valorDepositado;
	}

	@Override
	public String toString() {
		NumberFormat numeroFormatado = NumberFormat.getCurrencyInstance();
		return "$$$$$$ Informações da conta $$$$$$\n" 
				+ "Numero da conta: " + this.getNumero() + "\n"
				+ "Nome da agência: " + this.getBanco().getNome() + "\n"
				+ "Número da agência: " + this.getBanco().getNumero() + "\n" 
				+ "Cliente: " + this.getCliente().getNome() + "\n" 
				+ "CPF: " + this.getCliente().getCpf() + "\n" 
				+ "Saldo " + numeroFormatado.format(this.getSaldo()) + "\n"
				+ "------------------------------";
	}
}
