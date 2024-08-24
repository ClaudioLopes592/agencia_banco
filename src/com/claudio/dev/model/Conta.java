package com.claudio.dev.model;

import javax.swing.JOptionPane;

import utils.Formatador;

public class Conta {

	private static int contadorDeContas = 1;
	private int numeroConta;
	private Pessoa pessoa;
	private double saldo = 0.0;

	public Conta(Pessoa pessoa) {
		super();
		this.numeroConta = contadorDeContas;
		this.pessoa = pessoa;
		contadorDeContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return "\nNúumero da conta: " + this.getNumeroConta() + "\nNome do cliente: " + this.pessoa.getNome()
				+ "\nCpf: " + this.pessoa.getCpf() + "\nEmail: " + this.pessoa.getEmail() + "\nSaldo: "
				+ Formatador.doubleToString(this.getSaldo()) + "\n";
	}

	public void depositar(double valor) {

		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Seu depósito foi realizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realzar seu depósito!");
		}
	}

	public void sacar(double valor) {

		if (valor > 0 && getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar o saque!");
		}
	}

	public void transferir(Conta contaParaDeposito, double valor) {

		if (valor > 0 && getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			JOptionPane.showMessageDialog(null, "Sua transferência foi realizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferência!");
		}
	}
}
