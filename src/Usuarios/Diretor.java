package Usuarios;

public class Diretor extends Funcionario {

	public Diretor() {
		super();
	}

	public Diretor(String nome, String cpf, String cargo, int senha) {
		super(nome, cargo, cpf, senha);
	}

	@Override
	public String toString() {
		return "\nDiretor\n\nNome: " + getNome() + "\nCPF: " + getCpf() + "\nSenha: " + getSenha() + "\nCargo: " + getTipo() + "\nSaldo: "
				+ getSaldo() + "\nAgência: " + getAgencia() + "\n";

	}

}