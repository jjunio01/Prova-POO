package com.github.jjunio01.Prova.POO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.github.jjunio01.Prova.POO.entities.Banco;
import com.github.jjunio01.Prova.POO.entities.Cliente;
import com.github.jjunio01.Prova.POO.entities.Conta;
import com.github.jjunio01.Prova.POO.entities.Poupanca;

/**
 * @author JJunio
 *
 */
public class Main {

	public static List<Conta> contasCadastradas = new ArrayList<>();

	public static void main(String[] args) {
		boolean executando = true;
		while (executando) {
			String opcao = JOptionPane.showInputDialog(null,
					"Sistema JJBank\n" + "#1 Cadastrar Conta ou Poupança\n" + "#2 Efetuar depósito\n"
							+ "#3 Render Juros\n" + "#4 Consultar informações da agência\n"
							+ "#5 Mudar a conta da agência\n" + "#6 Consultar Cadastro\n" + "#0 Sair",
					"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE);
			if (opcao == null) {
				break;
			} else {
				switch (opcao) {
				case "1":
					while (true) {
						String subOpcao = JOptionPane.showInputDialog(null,
								"Escolha o tipo de conta que deseja abrir\n" + "#1 Conta Comum JJBank\n"
										+ "#2 Conta Poupança JJBank\n" + "#3 Cancelar abertura",
								"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE);
						if (subOpcao == null) {
							break;
						} else if (subOpcao.equals("1")) {
							cadastrarConta(1);
							JOptionPane.showMessageDialog(null, "Parabéns você agora tem uma conta JJBank",
									"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.INFORMATION_MESSAGE);
							break;
						} else if (subOpcao.equals("2")) {
							cadastrarConta(2);
							JOptionPane.showMessageDialog(null, "Parabéns você agora tem uma  Poupança JJBank",
									"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.INFORMATION_MESSAGE);
							break;
						} else if (subOpcao.equals("3")) {
							break;
						} else {
							JOptionPane.showMessageDialog(null, "Digite uma das opções válidas do menu.",
									"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.ERROR_MESSAGE);
						}
					}
					break;
				case "2":
					Conta contaDeposito = consultarCadastroCPF();
					if (contaDeposito != null) {
						JOptionPane.showMessageDialog(null, contaDeposito.toString(),
								"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.INFORMATION_MESSAGE);
						while (true) {
							try {
								double valorDeposito = Double
										.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor para depósito:",
												"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE));
								contaDeposito.depositar(valorDeposito);
								JOptionPane.showMessageDialog(null,
										"Deposito realizado com sucesso no valor de R$ " + valorDeposito,
										"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.INFORMATION_MESSAGE);
								break;
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Digite um valor número para efetuar depósito.",
										"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					break;
				case "3":
					Conta poupanca = consultarCadastroCPF();
					if (poupanca != null) {
						if (poupanca instanceof Poupanca) {
							((Poupanca) poupanca).renderJuros();
							JOptionPane.showMessageDialog(null,
									"Juros calculados com sucesso\n\n" + poupanca.toString(),
									"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null,
									"Conta do CPF: " + poupanca.getCliente().getCpf() + " não é uma poupança\n"
											+ "Render juros é exclusivo para contas poupanças\n"
											+ "Faça já a abertura de sua Poupança JJBank",
									"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE);
						}
					}
					break;
				case "4":
					break;
				case "5":
					Conta contaAlteracao = consultarCadastroCPF();
					if (contaAlteracao != null) {
						String novoNumeroAgencia = JOptionPane.showInputDialog(null,
								"Digite o novo número da sua agência JJBank", "$$$$$ -- Sistema JJBank -- $$$$$",
								JOptionPane.QUESTION_MESSAGE);
						String novoNomeAgencia = JOptionPane.showInputDialog(null,
								"Digite o novo nome da sua agência JJBank", "$$$$$ -- Sistema JJBank -- $$$$$",
								JOptionPane.QUESTION_MESSAGE);
						contaAlteracao.setBanco(new Banco(novoNumeroAgencia, novoNomeAgencia));
						JOptionPane.showMessageDialog(null,
								"Informações da Agência atualizadas com sucesso.\n\n" + contaAlteracao.toString(),
								"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE);
					}
					break;
				case "6":
					Conta contaConsulta = consultarCadastroCPF();
					if (contaConsulta != null) {
						JOptionPane.showMessageDialog(null, contaConsulta.toString(),
								"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE);
					}

					break;
				case "0":
					executando = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Digite uma das opções válidas do menu.",
							"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		}

	}

	public static void cadastrarConta(int tipo) {

		String numeroConta = JOptionPane.showInputDialog(null, "Digite o número da sua conta",
				"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE);

		String numeroBanco = JOptionPane.showInputDialog(null, "Digite o número da sua agência JJBank",
				"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE);
		String nomeBanco = JOptionPane.showInputDialog(null, "Digite o nome da sua agência JJBank",
				"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE);
		Banco banco = new Banco(numeroBanco, nomeBanco);

		String nomeCliente = JOptionPane.showInputDialog(null, "Digite o seu nome", "$$$$$ -- Sistema JJBank -- $$$$$",
				JOptionPane.QUESTION_MESSAGE);
		String numeroCPF = JOptionPane.showInputDialog(null, "Digite o número de seu CPF",
				"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE);
		Cliente cliente = new Cliente(nomeCliente, numeroCPF);
		double saldoInicial = 0.0;
		boolean validar = true;
		while (validar) {

			try {
				saldoInicial = Double
						.parseDouble(JOptionPane.showInputDialog(null, "Digite o saldo inicial da sua conta",
								"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.QUESTION_MESSAGE));
				validar = false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite apenas número para a opção saldo",
						"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (tipo == 1) {
			Conta conta = new Conta(numeroConta, banco, cliente, saldoInicial);
			salvarInformacoes(conta);
			JOptionPane.showMessageDialog(null, conta.toString(), "$$$$$ -- Sistema JJBank -- $$$$$",
					JOptionPane.QUESTION_MESSAGE);
		} else if (tipo == 2) {
			Poupanca poupanca = new Poupanca(numeroConta, banco, cliente, saldoInicial);
			salvarInformacoes(poupanca);
			JOptionPane.showMessageDialog(null, poupanca.toString(), "$$$$$ -- Sistema JJBank -- $$$$$",
					JOptionPane.QUESTION_MESSAGE);
		}

	}

	public static Conta consultarCadastroNome() {

		if (contasCadastradas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não existem contas abertas no JJBank",
					"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.ERROR_MESSAGE);
		} else {
			String nome = JOptionPane.showInputDialog(null, "Digite o seu nome", "$$$$$ -- Sistema JJBank -- $$$$$",
					JOptionPane.QUESTION_MESSAGE);
			boolean buscarConta = true;
			for (int i = 0; i < contasCadastradas.size(); i++) {
				if (contasCadastradas.get(i).getCliente().getNome().equals(nome)) {
					buscarConta = false;
					return contasCadastradas.get(i);
				}
			}
			if (buscarConta) {
				JOptionPane.showMessageDialog(null, "Não existem contas abertas para: " + nome + " no JJBank",
						"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.ERROR_MESSAGE);
			}

		}
		return null;
	}

	public static Conta consultarCadastroCPF() {

		if (contasCadastradas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não existem contas abertas no JJBank",
					"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.ERROR_MESSAGE);
		} else {
			String cpf = JOptionPane.showInputDialog(null, "Digite o seu CPF", "$$$$$ -- Sistema JJBank -- $$$$$",
					JOptionPane.QUESTION_MESSAGE);
			boolean buscarConta = true;
			for (int i = 0; i < contasCadastradas.size(); i++) {
				if (contasCadastradas.get(i).getCliente().getCpf().equals(cpf)) {
					buscarConta = false;
					return contasCadastradas.get(i);
				}
			}
			if (buscarConta) {
				JOptionPane.showMessageDialog(null, "Não existem contas abertas para o CPF: " + cpf + " no JJBank",
						"$$$$$ -- Sistema JJBank -- $$$$$", JOptionPane.ERROR_MESSAGE);
			}

		}
		return null;
	}

	public static void salvarInformacoes(Conta conta) {
		contasCadastradas.add(conta);
	}
}
