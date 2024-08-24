package com.claudio.dev.main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.claudio.dev.model.Conta;
import com.claudio.dev.model.Pessoa;

public class Main {

	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {

		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog("... Selecione uma operação ..."
				+ "\n|    Opção 1 - Criar conta" + "\n|    Opção 2 - Depositar" + "\n|    Opção 3 - Sacar"
				+ "\n|    Opção 4 - Transferir" + "\n|    Opção 5 - Listar" + "\n|    Opção 6 - Sair"));

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			realizarDeposito();
			break;
		case 3:
			realizarSaque();
			break;
		case 4:
			realizarTransferencia();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Obrigado por usar nossos serviços!");
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!");
			operacoes();
			break;
		}
	}

	public static void criarConta() {

		Pessoa pessoa = new Pessoa();

		pessoa.setNome(JOptionPane.showInputDialog("Nome "));

		pessoa.setCpf(JOptionPane.showInputDialog("Cpf "));

		pessoa.setEmail(JOptionPane.showInputDialog("Email "));

		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);
		JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");

		operacoes();
	}

	private static Conta encontrarConta(int numeroConta) {

		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) {
					conta = c;
				}
			}
		}
		return conta;
	}

	public static void realizarDeposito() {

		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para depósito "));
		Conta conta = encontrarConta(numeroConta);
		if (conta != null) {
			double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar? "));
			conta.depositar(valorDeposito);
		} else {
			JOptionPane.showMessageDialog(null, "Conta não localizada!");
		}
		operacoes();
	}

	public static void realizarSaque() {

		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para realizar o saque "));
		Conta conta = encontrarConta(numeroConta);
		if (conta != null) {
			double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar? "));
			conta.sacar(valorSaque);
		} else {
			JOptionPane.showMessageDialog(null, "Conta não localizada!");
		}
		operacoes();
	}

	public static void realizarTransferencia() {

		int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do remetente "));
		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			int numeroContaDestinatario = Integer
					.parseInt(JOptionPane.showInputDialog("Número da conta do destinatário "));
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			if (contaDestinatario != null) {
				double valor = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja tranferir? "));
				contaRemetente.transferir(contaDestinatario, valor);
			} else {
				JOptionPane.showMessageDialog(null, "A conta para depósito não foi encontrada!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "A conta para transferência não foi encontrada!");
		}
		operacoes();
	}

	public static void listarContas() {

		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				JOptionPane.showMessageDialog(null, conta);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
		}
		operacoes();
	}

}
