package Usuarios;

public class Gerente extends Funcionario{
	
	private int agencia;
	
	public Gerente() {
	}

	public Gerente(String nome, String cpf, String cargo, int senha, int agencia) {
		super(nome, cargo, cpf, senha);
		this.agencia = agencia;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "\nGerente\n\nNome: " + getNome() + "\nCPF: " + getCpf() + "\nSenha: " + getSenha() + "\nCargo: " + getTipo() + "\nSaldo: "
				+ getSaldo() + "\nAgência: " + getAgencia() + "\n";
	}
				
}