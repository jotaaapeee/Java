package Usuarios;

import Conta.Conta;

public class Usuario extends Conta implements Comparable<Usuario>{
	
	private String tipo;
	private String nome;
	private String cpf;
	private int senha;
	
	public Usuario(String nome, String cpf, int senha, String tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public Usuario() {}

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

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
    public int compareTo(Usuario usuario) {
		return this.getNome().compareToIgnoreCase(usuario.getNome());
    }
	
}