package Conta;

public class ContaCorrente extends Conta {

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String cpf, double saldo, int agencia, String tipoConta) {
		super(cpf, saldo, agencia, tipoConta);
	}

	@Override
	public String sacar(double valor) {
		double novoSaldo;
		if (this.getSaldo() > valor + saque) {
			novoSaldo = this.getSaldo() - valor - saque;
			this.setSaldo(novoSaldo);
			double total = getTotalTributos() + saque;
			setTotalTributos(total);
			return "Saque realizado com sucesso!";
		} else {
			return "Saldo insuficiente para saque.";
		}
	}

	@Override
	public String depositar(double valor) {
		double novoSaldo = this.getSaldo() + valor - deposito;
		this.setSaldo(novoSaldo);
		double total = getTotalTributos() + deposito;
		setTotalTributos(total);
		return "Depósito realizado com sucesso!";
	}

	@Override
	public String transferir(double valor, Conta conta) {
		if (this.getSaldo() > valor + transferencia) {
			double novoSaldo = getSaldo() - valor - transferencia;
			this.setSaldo(novoSaldo);
			conta.setSaldo(conta.getSaldo() + valor);
			double total = getTotalTributos() + transferencia;
			setTotalTributos(total);
			return "Transferência realizada com sucesso!";
		} else {
			return "Saldo insuficiente para transferência.";
		}
	}

	@Override
	public String toString() {
		return "\nConta Corrente\n\nCPF do titular: " + getCpf() + 
				"\nAgência: " + getAgencia() + 
				"\nSaldo: " + getSaldo() + "\n";
	}

}