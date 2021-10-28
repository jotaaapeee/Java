package Usuarios;

public class Presidente extends Funcionario{
	
	public Presidente() {

	}

	public Presidente(String nome, String cpf, String cargo, int senha) {
		super(nome, cargo, cpf, senha);
	}

	@Override
	public String toString() {
		return "\nPresidente\n\nNome: " + getNome() + "\nCPF: " + getCpf() + "\nSenha: " + getSenha() + "\nCargo: " + getTipo() + "\nSaldo: "
				+ getSaldo() + "\nAgência: " + getAgencia() + "\n";
	}
}