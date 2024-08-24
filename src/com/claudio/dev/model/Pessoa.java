package com.claudio.dev.model;

public class Pessoa {
	
	private static int count = 0;
	private String nome;
	private String cpf;
	private String email;
	
	public Pessoa() {
		super();
	}

	public Pessoa(Integer count, String nome, String cpf, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		count += 1;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Pessoa.count = count;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "\nNome: " + this.getNome() +
			   "\nCpf: " + this.getCpf() +
			   "\nEmail: " + this.getEmail();
	}

}
