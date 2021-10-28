package Conta;

public class ContaPoupanca extends Conta{
	
	private double valorRendimento;

	public ContaPoupanca(String cpf, double saldo, int agencia, String tipoConta) {
		super(cpf, saldo, agencia, tipoConta);
	}

	public ContaPoupanca() {
		super();
	}
	
	
	public double getValorRendimento() {
		return valorRendimento;
	}

	public void setValorRendimento(double valorRendimento) {
		this.valorRendimento = valorRendimento;
	}

	public double calcularRendimentoPoupanca(double valor, int dias) {
        double valorFinal = valor * rendimentoPoupancaDia * dias;
            this.valorRendimento = valorFinal;
        return valorFinal;
    }

	@Override
	public String toString() {
		return "\nConta Poupança\n\nCPF do titular: " + getCpf() + 
				"\nAgência: " + getAgencia() + 
				"\nSaldo: " + getSaldo() + "\n";
	}
	
	
}