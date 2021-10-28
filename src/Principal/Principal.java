package Principal;

import java.util.InputMismatchException;

import java.util.List;
import java.util.Scanner;

import Conta.Conta;
import Conta.ContaPoupanca;
import Conta.Taxas;
import Enums.ContasEnum;
import Enums.UsuariosEnum;
import Relatorios.RelatDeposito;
import Relatorios.RelatSaque;
import Relatorios.RelatTransferencia;
import Relatorios.RelatDiretor;
import Relatorios.RelatGerente;
import Relatorios.RelatPresidente;
import Relatorios.RendPoupanca;
import Relatorios.Saldo;
import Relatorios.TaxaCC;
import Relatorios.TaxaSeguroDeVida;
import Usuarios.Usuario;

public class Principal {

	static Scanner leitor = new Scanner(System.in);
	static String cpf;

	public static void menuGeral(List<Usuario> listaUsuarios, List<Conta> listaConta) throws Exception {
		Usuario ul = null, u = null;
		Conta cl = null, c = null;
		boolean continua = true;
		do {
			try {
				System.out.println("\nBem Vindo ao Banco Seique Seiquel�!\n");
				System.out.print("Digite seu CPF: ");
				cpf = leitor.next();
				System.out.print("Digite sua senha: ");
				int senha = leitor.nextInt();

				
				for (int i = 0; i < listaUsuarios.size(); i++) {
					ul = listaUsuarios.get(i);
					if (ul.getCpf().equalsIgnoreCase(cpf)) {
						u = listaUsuarios.get(i);
					}

				}

				for (int i = 0; i < listaConta.size(); i++) {
					cl = listaConta.get(i);
					if (cl.getCpf().equalsIgnoreCase(cpf)) {
						c = listaConta.get(i);
					}
				}

				System.out.println("\nBem vindo(a), " + u.getNome());

				if (u.getCpf().equalsIgnoreCase(cpf) && u.getSenha() == senha
						&& u.getTipo().equalsIgnoreCase(UsuariosEnum.CLIENTE.name())) {
					menuCliente(listaUsuarios, u, c, listaConta);
				} else if (u.getCpf().equalsIgnoreCase(cpf) && u.getSenha() == senha
						&& u.getTipo().equalsIgnoreCase(UsuariosEnum.GERENTE.name())) {
					menuFuncionario(u, c, listaUsuarios, listaConta);
				} else if (u.getCpf().equalsIgnoreCase(cpf) && u.getSenha() == senha
						&& u.getTipo().equalsIgnoreCase(UsuariosEnum.DIRETOR.name())) {
					menuFuncionario(u, c, listaUsuarios, listaConta);
				} else if (u.getCpf().equalsIgnoreCase(cpf) && u.getSenha() == senha
						&& u.getTipo().equalsIgnoreCase(UsuariosEnum.PRESIDENTE.name())) {
					menuFuncionario(u, c, listaUsuarios, listaConta);
				}
				continua = false;
				if (u.getSenha() != senha) {
					continua = true;
					System.out.println("Senha incorreta! Tente novamente.");
				}
			} catch (NullPointerException ex) {
				System.out.println("\nCPF n�o cadastrado.");
			} catch (InputMismatchException ex) {
				System.out.println("\nPor favor, digite somente n�meros.");
				leitor.nextLine();
			} 

		} while (continua);
	}

	public static void menuFuncionario(Usuario u, Conta c, List<Usuario> listaUsuarios, List<Conta> listaConta)
			throws Exception {
		boolean continua = true;

		do {
			try {
				int entrada;
				System.out.println("\nGostaria de acessar como: ");
				System.out.println("\n1 - Cliente\n2 - Funcion�rio");
				System.out.print("--> ");
				entrada = leitor.nextInt();
				
				if (entrada == 1) {
					menuCliente(listaUsuarios, u, c, listaConta);
				} else if (entrada == 2 && u.getTipo().equalsIgnoreCase(UsuariosEnum.GERENTE.name())) {
					menuGerente(listaUsuarios, u, c, listaConta);
				} else if (entrada == 2 && u.getTipo().equalsIgnoreCase(UsuariosEnum.DIRETOR.name())) {
					menuDiretor(u, c, listaUsuarios, listaConta);
				} else if (entrada == 2 && u.getTipo().equalsIgnoreCase(UsuariosEnum.PRESIDENTE.name())) {
					menuPresidente(u, c, listaConta, listaUsuarios);
				}

				continua = false;
			} catch (InputMismatchException ex) {
				System.out.println("\nPor favor, digite somente n�meros.");
				leitor.nextLine();
			}
		} while (continua);
	}

	public static void menuCliente(List<Usuario> listaUsuarios, Usuario u, Conta conta, List<Conta> listaConta)
			throws Exception {
		int op1 = 1, op2 = 1, op3 = 0, r = 0;
		double valor = 0.0;
		int dias;
		String cpf;

		do {
			boolean continua = true;
			do {
				do {
					try {
						if (op1 != 1 && op1 != 2) {
							System.out.println("Tente novamente.");
						}
						System.out.println("\n1 - Movimenta��es da conta\n2 - Relat�rios\n3 - Sair");
						System.out.print("--> ");
						op1 = leitor.nextInt();
						if (op1 == 3) {
							menuGeral(listaUsuarios, listaConta);
						}
						continua = false;
					} catch (InputMismatchException ex) {
						System.out.println("\nPor favor, digite somente n�meros.");
						leitor.nextLine();
					}
				} while (continua);
			} while (op1 != 1 && op1 != 2);

			// submenu
			if (op1 == 1) {
				do {
					continua = true;
					do {
						try {
							if (op2 < 1 || op2 > 4) {
								System.out.println("Tente novamente.");
							}
							System.out.println("\n1 - Saque\n2 - Dep�sito\n3 - Transfer�ncia\n4 - Contratar seguro de vida\n5 - Voltar ao menu anterior");
							System.out.print("--> ");
							op2 = leitor.nextInt();
							continua = false;
						} catch (InputMismatchException ex) {
							System.out.println("\nPor favor, digite somente n�meros.");
							leitor.nextLine();
						}
					} while (continua);
				} while (op2 < 1 || op2 > 5);
				if (op2 == 1) {
					op3 = 11;
				} else if (op2 == 2) {
					op3 = 12;
				} else if (op2 == 3) {
					op3 = 13;
				} else if (op2 == 4) {
					op3 = 14;
				} else if (op2 == 5) {
					menuCliente(listaUsuarios, u, conta, listaConta);
				}

			} else if (op1 == 2) {
				do {
					continua = true;
					do {
						try {
							if (op2 < 1 || op2 > 4) {
								System.out.println("Opcao inv�lida! Tente novamente.");
							}
							System.out.println("\n1 - Saldo\n2 - Relat�rio de tributa��o da conta corrente\n"
									+ "3 - Relat�rio de rendimento da poupan�a\n"
									+ "4 - Relat�rio de tributa��o referente ao seguro de vida\n"
									+ "5 - Voltar ao menu anterior");
							System.out.print("--> ");
							op2 = leitor.nextInt();
							continua = false;
						} catch (InputMismatchException ex) {
							System.out.println("\nPor favor, digite somente n�meros.");
							leitor.nextLine();
						}
					} while (continua);
				} while (op2 < 1 || op2 > 5);

				if (op2 == 1) {
					op3 = 21;
				} else if (op2 == 2) {
					op3 = 22;
				} else if (op2 == 3) {
					op3 = 23;
				} else if (op2 == 4) {
					op3 = 24;
				} else if (op2 == 5) {
					menuCliente(listaUsuarios, u, conta, listaConta);
				}
			}

			if (op3 == 11) {

				do {
					continua = true;
					try {
						System.out.println("0 - Cancelar");
						System.out.print("\nDigite o valor que deseja sacar: ");
						valor = leitor.nextDouble();
						if (valor == 0) {
							menuGeral(listaUsuarios, listaConta);
						}
						if ((valor + Taxas.saque) > conta.getSaldo()) {
							throw new Exception(conta.sacar(valor));
						}

						if (valor < 0) {
							throw new Exception("N�o � poss�vel sacar valores negativos.");
						}
						continua = false;
					} catch (InputMismatchException ex) {
						System.out.println("\nPor favor, digite somente n�meros.");
						leitor.nextLine();

					} catch (Exception erro1) {
						System.err.println(erro1.getMessage());
						leitor.nextLine();
					}
				} while (continua);

				double saldoAnterior = conta.getSaldo();
				conta.sacar(valor);
				double novoSaldo = conta.getSaldo();

				System.out.format("\nSaldo anterior: %.2f", saldoAnterior);
				System.out.format("\nValor sacado: %.2f", valor);
				System.out.format("\nSaldo atual: %.2f", novoSaldo);
				RelatSaque.pathSaque(conta, u, valor);
				System.out.println();
				r = 1;
				do {
					continua = true;
					do {
						try {
							if (r != 1 && r != 2) {
								System.out.println("Tente novamente.");
							}
							System.out.println("\nDeseja fazer outra opera��o? ");
							System.out.println("1 - Sim\n2 - N�o");
							System.out.print("--> ");
							r = leitor.nextInt();
							continua = false;
						} catch (InputMismatchException ex) {
							System.out.println("\nPor favor, digite somente n�meros.");
							leitor.nextLine();
							System.out.println("Tente novamente.");

						}
					} while (continua);
				} while (r != 1 && r != 2);

			} else if (op3 == 12) {
				continua = true;
				do {
					try {
						System.out.println("0 - Cancelar");
						System.out.print("\nDigite o valor que deseja depositar: ");
						valor = leitor.nextDouble();
						if (valor == 0) {
							menuGeral(listaUsuarios, listaConta);
						}
						if (valor < 0) {
							throw new Exception("N�o � poss�vel depositar valores negativos.");
						}
						continua = false;
					} catch (InputMismatchException ex) {
						System.out.println("\nPor favor, digite somente n�meros.");
						leitor.nextLine();

					} catch (Exception erro1) {
						System.err.println(erro1.getMessage());
						leitor.nextLine();
					}
				} while (continua);
				double saldoAnterior = conta.getSaldo();
				conta.depositar(valor);
				double novoSaldo = conta.getSaldo();

				System.out.format("\nSaldo anterior: %.2f", saldoAnterior);
				System.out.format("\nValor depositado: %.2f", valor);
				System.out.format("\nSaldo atual: %.2f", novoSaldo);
				RelatDeposito.pathDeposito(conta, valor, u);
				System.out.println();
				r = 1;
				do {
					continua = true;
					do {
						try {
							if (r != 1 && r != 2) {
								System.out.println("Op��o inv�lida! Tente novamente.");
							}
							System.out.println("\nDeseja fazer outra opera��o? ");
							System.out.println("1 - Sim\n2 - N�o");
							System.out.print("--> ");
							r = leitor.nextInt();
							continua = false;
						} catch (InputMismatchException ex) {
							System.out.println("\nPor favor, digite somente n�meros.");
							leitor.nextLine();
							System.out.println("Tente novamente.");

						}
					} while (continua);
				} while (r != 1 && r != 2);

			} else if (op3 == 13) {
				Conta contaDestinatario = null;
				Usuario destinatario = null;
				continua = true;
				do {
					try {
						System.out.println("0 - Cancelar");
						System.out.print("\nDigite o valor que deseja transferir: ");
						valor = leitor.nextDouble();
						if (valor == 0) {
							menuGeral(listaUsuarios, listaConta);
						}
						if ((valor + Taxas.transferencia) > conta.getSaldo()) {
							throw new Exception(conta.transferir(valor, conta));
						}

						if (valor < 0) {
							throw new Exception("N�o � poss�vel transferir valores negativos.");
						}
						System.out.print("\nDigite o CPF do destinat�rio: ");
						cpf = leitor.next();
						Conta cl = null;

						for (int i = 0; i < listaConta.size(); i++) {
							cl = listaConta.get(i);
							if (cl.getCpf().equalsIgnoreCase(cpf)) {
								contaDestinatario = listaConta.get(i);
							}
						}
						for (int i = 0; i < listaConta.size(); i++) {
							cl = listaConta.get(i);
							if (cl.getCpf().equalsIgnoreCase(cpf)) {
								destinatario = listaUsuarios.get(i);
							}
						}

						if (destinatario == null && contaDestinatario == null) {
							throw new Exception("Destinat�rio n�o encontrado! Tente novamente.");
						}
						continua = false;
					} catch (InputMismatchException ex) {
						System.out.println("\nPor favor, digite somente n�meros.");
						leitor.nextLine();
						
					} catch (Exception erro1) {
						System.err.println(erro1.getMessage());
						leitor.nextLine();
					}
				} while (continua);

				int transferir = 1;
				do {
					continua = true;
					do {
						try {
							if (transferir != 1 && transferir != 2) {
								System.out.println("Op��o inv�lida! Tente novamente.");
							}
							System.out.println("\nPor favor, confirme os dados: ");
							System.out.println("\nNome do destinat�rio: " + destinatario.getNome());
							System.out.println("CPF do destinat�rio: " + destinatario.getCpf());
							System.out.format("Valor da transfer�ncia: %.2f", valor);
							System.out.println();

							System.out.println("\nDeseja continuar? ");
							System.out.println("1 - Sim\n2 - N�o");
							System.out.print("--> ");
							transferir = leitor.nextInt();
							continua = false;
						} catch (InputMismatchException ex) {
							System.out.println("\nPor favor, digite somente n�meros.");
							leitor.nextLine();
							System.out.println("Tente novamente.");

						}
					} while (continua);
				} while (transferir != 1 && transferir != 2);

				if (transferir == 1) {
					double saldoAnterior = conta.getSaldo();
					conta.transferir(valor, contaDestinatario);
					double novoSaldo = conta.getSaldo();

					System.out.format("\nSaldo anterior: %.2f", saldoAnterior);
					System.out.format("\nValor transferido: %.2f", valor);
					System.out.println("\nNome do destinat�rio: " + destinatario.getNome());
					System.out.println("CPF do destinat�rio: " + destinatario.getCpf());
					System.out.format("\n\nSaldo atual: %.2f", novoSaldo);

					RelatTransferencia.pathTransferencia(conta, valor, u, destinatario);
					System.out.println();
					r = 1;
					do {
						continua = true;
						do {
							try {
								if (r != 1 && r != 2) {
									System.out.println("Op��o inv�lida! Tente novamente.");
								}
								System.out.println("\nDeseja fazer outra opera��o? ");
								System.out.println("1 - Sim\n2 - N�o");
								System.out.print("--> ");
								r = leitor.nextInt();
								continua = false;
							} catch (InputMismatchException ex) {
								System.out.println("\nPor favor, digite somente n�meros.");
								leitor.nextLine();
								System.out.println("Tente novamente.");

							}
						} while (continua);
					} while (r != 1 && r != 2);
				}

			} else if (op3 == 14) {
				continua = true;

				do {
					try {
						System.out.println("0 - Cancelar");
						System.out.print("\nDigite o valor que ser� segurado: ");
						valor = leitor.nextDouble();
						if (valor == 0) {
							menuGeral(listaUsuarios, listaConta);
						}
						if (valor < 0) {
							throw new Exception("N�o � poss�vel contratar com valores negativos.");
						}
						if ((conta.calculoTributoSeguroDeVida(valor)) < conta.getSaldo()) {
							System.out.format("\nO valor segurado �: %.2f", conta.contratarSeguro(valor));
						}

						if ((conta.calculoTributoSeguroDeVida(valor)) > conta.getSaldo()) {
							throw new Exception("Saldo insuficiente para a contrata��o!");
						}
						continua = false;
					} catch (InputMismatchException ex) {
						System.out.println("\nPor favor, digite somente n�meros.");
						leitor.nextLine();
						

					} catch (Exception erro1) {
						System.err.println(erro1.getMessage());
						leitor.nextLine();
					}
				} while (continua);

				System.out.println();
				r = 1;
				do {
					continua = true;
					do {
						try {
							if (r != 1 && r != 2) {
								System.out.println("Tente novamente.");
							}
							System.out.println("\nDeseja fazer outra opera��o? ");
							System.out.println("1 - Sim\n2 - N�o");
							System.out.print("--> ");
							r = leitor.nextInt();
							continua = false;
						} catch (InputMismatchException ex) {
							System.out.println("\nPor favor, digite somente n�meros.");
							leitor.nextLine();
							System.out.println("Tente novamente.");

						}
					} while (continua);
				} while (r != 1 && r != 2);

			} else if (op3 == 21) {
				System.out.format("\nSaldo atual de: R$ %.2f", conta.getSaldo());
				Saldo.pathsaldo(u, conta);

				System.out.println();
				r = 1;
				do {
					continua = true;
					do {
						try {
							if (r != 1 && r != 2) {
								System.out.println("Tente novamente.");
							}
							System.out.println("\nDeseja fazer outra opera��o? ");
							System.out.println("1 - Sim\n2 - N�o");
							System.out.print("--> ");
							r = leitor.nextInt();
							continua = false;
						} catch (InputMismatchException ex) {
							System.out.println("\nPor favor, digite somente n�meros.");
							leitor.nextLine();
							System.out.println("Tente novamente.");

						}
					} while (continua);
				} while (r != 1 && r != 2);

			} else if (op3 == 22) {
				try {
					System.out.println("\nRelat�rio de tributa��o da conta corrente");
					if (conta.getTipo().equalsIgnoreCase(ContasEnum.CONTAPOUPANCA.name())) {
						throw new ClassCastException();
					}
					System.out.println("\nTributac�o por opera��o banc�ria");
					System.out.format("\n- Tributac�o para saque: R$ %.2f", Taxas.saque);
					System.out.format("\n- Tributac�o para dep�sito: R$ %.2f", Taxas.deposito);
					System.out.format("\n- Tributac�o para transfer�ncia: R$ %.2f", Taxas.transferencia);
					System.out.format("\n- Tributac�o para seguro de vida em porcentagem: %.2f",
							Taxas.transferencia);
					System.out.format("\n\nGasto total da tributa��o: %.2f", conta.getTotalTributos());
					TaxaCC.pathTributacao(u, conta);
					System.out.println();
					r = 1;
					do {
						continua = true;
						do {
							try {
								if (r != 1 && r != 2) {
									System.out.println("Tente novamente.");
								}
								System.out.println("\nDeseja fazer outra opera��o? ");
								System.out.println("1 - Sim");
								System.out.println("2 - N�o");
								System.out.print("--> ");
								r = leitor.nextInt();
								continua = false;
							} catch (InputMismatchException ex) {
								System.out.println("\nPor favor, digite somente n�meros.");
								leitor.nextLine();
								System.out.println("Tente novamente.");

							}
						} while (continua);
					} while (r != 1 && r != 2);

				} catch (ClassCastException cce) {
					System.out.println("Voc� n�o possui conta corrente para realizar esta opera��o!");
					menuCliente(listaUsuarios, u, conta, listaConta);
				}
			} else if (op3 == 23) {
				continua = true;
				do {
					try {
						System.out.println("Relat�rio de rendimento da poupan�a");
						if (conta.getTipo().equalsIgnoreCase(ContasEnum.CONTACORRENTE.name())) {
							throw new ClassCastException();
						}
						System.out.println("\nSimula��o");
						System.out.println("0 - Cancelar");
						System.out.print("\nDigite o valor que deseja simular: ");
						valor = leitor.nextDouble();
						continua = false;
					} catch (InputMismatchException ex) {
						System.out.println("\nPor favor, digite somente n�meros.");
						leitor.nextLine();
					} catch (ClassCastException ex) {
						System.out.println("Voc� n�o possui conta poupan�a para realizar esta opera��o!");
						menuCliente(listaUsuarios, u, conta, listaConta);
					}
				} while (continua);
				
				if (valor == 0) {
					menuGeral(listaUsuarios, listaConta);
				}
				
				continua = true;
				double valorFinal = 0;
				double rendimento = 0;
				dias = 0;
				do {
					try {
						System.out.print("Digite a quantidade de dias desejada: ");
						dias = leitor.nextInt();
						rendimento = ((ContaPoupanca) conta).calcularRendimentoPoupanca(valor, dias);
						valorFinal = rendimento + valor;
						continua = false;
					} catch (InputMismatchException ex) {
						System.out.println("\nPor favor, digite somente n�meros.");
						leitor.nextLine();

					}
				} while (continua);	

				try {
					System.out.println("Relat�rio de rendimento da poupan�a");
					System.out.format("\nO rendimento de R$ %.2f", valor);
					System.out.print(" durante " + dias + " dias � de ");
					System.out.format("R$ %.2f", rendimento);
					
					System.out.format("\nO valor total � R$ %.2f", valorFinal);
					RendPoupanca.pathRendimento(conta, u, valor, dias);
					System.out.println();
					r = 1;
					
					do {
						continua = true;
						do {
							try {
								if (r != 1 && r != 2) {
									System.out.println("Op��o inv�lida! Tente novamente.");
								}
								System.out.println("\nDeseja fazer outra opera��o? ");
								System.out.println("1 - Sim\n2 - N�o");
								System.out.print("--> ");
								r = leitor.nextInt();
								continua = false;
							} catch (InputMismatchException ex) {
								System.out.println("\nPor favor, digite somente n�meros.");
								leitor.nextLine();
								System.out.println("Tente novamente.");

							}
						} while (continua);
					} while (r != 1 && r != 2);

				} catch (ClassCastException cce) {
					System.out.println("Voc� n�o possui conta poupan�a para realizar esta opera��o!");
				}
			} else if (op3 == 24) {
				System.out.println("Relatorio de tributa��o do seguro de vida");
				System.out.format("\nTributa��o do seguro de vida em porcentagem: %.2f",
						Taxas.porcentagemSeguroDeVida);
				System.out.format("\n\nGasto com a tributa��o do seguro de vida: R$ %.2f", conta.getvSeguro());
				TaxaSeguroDeVida.pathSeguro(conta, u);
				System.out.println();
				r = 1;
				do {
					continua = true;
					do {
						try {
							if (r != 1 && r != 2) {
								System.out.println("Op��o inv�lida! Tente novamente.");
							}
							System.out.println("\nDeseja fazer outra opera��o? ");
							System.out.println("1 - Sim\n2 - N�o");
							System.out.print("--> ");
							r = leitor.nextInt();
							continua = false;
						} catch (InputMismatchException ex) {
							System.out.println("\nPor favor, digite somente n�meros.");
							leitor.nextLine();
							System.out.println("Tente novamente.");

						}
					} while (continua);
				} while (r != 1 && r != 2);

			}
		} while (r != 2);

		if (r == 2)

		{
			System.out.println("\nObrigado por usar o Banco Seique Seiquel�!\nTenha um �timo dia!");
			System.exit(0);
		}

	}

	public static void menuGerente(List<Usuario> listaUsuarios, Usuario u, Conta conta, List<Conta> listaConta)
			throws Exception {

		int r = 0;

		System.out.println("\nRelat�rio de n�mero de contas de sua ag�ncia");
		System.out.println("\nTotal de contas de sua ag�ncia: " + RelatGerente.totalDeContasSupervisionadas(conta, u));
		System.out.println();
		r = 1;
		do {
			boolean continua = true;
			do {
				try {
					if (r != 1 && r != 2) {
						System.out.println("Tente novamente.");
					}
					System.out.println("\nGostaria de mudar para a interface cliente? ");
					System.out.println("1 - Sim\n2 - N�o");
					System.out.print("--> ");
					r = leitor.nextInt();
					continua = false;
				} catch (InputMismatchException ex) {
					System.out.println("\nPor favor, digite somente n�meros.");
					leitor.nextLine();
					System.out.println("Tente novamente.");

				}
			} while (continua);
		} while (r != 1 && r != 2);

		if (r == 1) {
			menuCliente(listaUsuarios, u, conta, listaConta);
		} else {
			menuGeral(listaUsuarios, listaConta);
		}

	}

	public static void menuDiretor(Usuario u, Conta conta, List<Usuario> listaUsuarios, List<Conta> listaConta)
			throws Exception {

		int r = 0;

		System.out.println("\nRelat�rio: Informa��es de todos os clientes");
		RelatDiretor.informacaoClientes(conta, u, listaUsuarios, listaConta);
		System.out.println();
		r = 1;
		do {
			boolean continua = true;
			do {
				try {
					if (r != 1 && r != 2) {
						System.out.println("Tente novamente.");
					}
					System.out.println("\nGostaria de mudar para a interface cliente? ");
					System.out.println("1 - Sim\n2 - N�o");
					System.out.print("--> ");
					r = leitor.nextInt();
					continua = false;
				} catch (InputMismatchException ex) {
					System.out.println("\nPor favor, digite somente n�meros.");
					leitor.nextLine();
					System.out.println("Tente novamente.");

				}
			} while (continua);
		} while (r != 1 && r != 2);

		if (r == 1) {
			menuCliente(listaUsuarios, u, conta, listaConta);
		} else {
			menuGeral(listaUsuarios, listaConta);
		}

	}

	public static void menuPresidente(Usuario u, Conta conta, List<Conta> listaConta, List<Usuario> listaUsuarios)
			throws Exception {

		int r = 0;

		System.out.println("\nRelat�rio: Valor total do capital armazenado no Banco");
		System.out.format("\nTotal de capital armazenado: R$ %.2f\n",
				RelatPresidente.totalDeCapital(conta, u, listaConta));
		
		System.out.println("\n\nRelat�rio de n�mero de contas de suas ag�ncias");
		System.out.println("\nTotal de contas da ag�ncia 001: " + conta.getTotalAgencia1());
		System.out.println("\nTotal de contas da ag�ncia 002: " + conta.getTotalAgencia2() + "\n");
		
		System.out.println("\nRelat�rio: Informa��es de todos os clientes");
		RelatDiretor.informacaoClientes(conta, u, listaUsuarios, listaConta);
		System.out.println();
		
		r = 1;
		do {
			boolean continua = true;
			do {
				try {
					if (r != 1 && r != 2) {
						System.out.println("Tente novamente.");
						break;
					}
					System.out.println("\nGostaria de mudar para a interface cliente? ");
					System.out.println("1 - Sim\n2 - N�o");
					System.out.print("--> ");
					r = leitor.nextInt();
					continua = false;
				} catch (InputMismatchException ex) {
					System.out.println("\nPor favor, digite somente n�meros.");
					leitor.nextLine();
					System.out.println("Tente novamente.");

				}
			} while (continua);
		} while (r != 1 && r != 2);

		if (r == 1) {
			menuCliente(listaUsuarios, u, conta, listaConta);
		} else {
			menuGeral(listaUsuarios, listaConta);
		}

	}

}