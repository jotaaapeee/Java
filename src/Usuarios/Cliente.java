package Usuarios;

public class Cliente extends Usuario {

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, String tipo, int senha) {
		super(nome, cpf, senha, tipo);
	}

	@Override
	public String toString() {
		return "\nCliente\n\nNome: " + getNome() + "\nCPF: " + getCpf() + "\nSenha: " + getSenha() + "\nSaldo: " + getSaldo() + "\nAgência: "
				+ getAgencia() + "\n";

	}

}