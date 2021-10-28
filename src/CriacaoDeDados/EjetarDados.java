package CriacaoDeDados;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Enums.ContasEnum;
import Enums.UsuariosEnum;
import Usuarios.Cliente;
import Usuarios.Diretor;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.Presidente;

public class EjetarDados {

	public static void leitorUsuarios(String path, List<Usuario> listaUsuarios) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";

		while (true) {

			linha = buffRead.readLine();

			if (linha != null) {
				String [] split = linha.split(",");

				if(split[2].equalsIgnoreCase(UsuariosEnum.DIRETOR.name())) {
					Diretor d = new Diretor(split[0], split[1], split[2], Integer.parseInt(split[3]));
					listaUsuarios.add(d);
				}
				else if(split[2].equalsIgnoreCase(UsuariosEnum.GERENTE.name())) {
					Gerente g = new Gerente(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]));
					listaUsuarios.add(g);
				}
				else if(split[2].equalsIgnoreCase(UsuariosEnum.PRESIDENTE.name())) {
					Presidente p = new Presidente(split[0], split[1], split[2], Integer.parseInt(split[3]));
					listaUsuarios.add(p);
				}
				else if(split[2].equalsIgnoreCase(UsuariosEnum.CLIENTE.name())) {
					Cliente c = new Cliente(split[0], split[1], split[2], Integer.parseInt(split[3]));
					listaUsuarios.add(c);

			}
		} else {
			break;
		}
		
		}
		buffRead.close();
	}
	
	public static void leitorContas(String path, List<Conta> listaConta) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		

		String linha = "";

		while (true) {

			linha = buffRead.readLine();

			if (linha != null) {
				String [] split = linha.split(",");

				if(split[3].equalsIgnoreCase(ContasEnum.CONTACORRENTE.name())) {
					ContaCorrente cc = new ContaCorrente(split[0], Double.parseDouble(split[1]), Integer.parseInt(split[2]), split[3]);
					listaConta.add(cc);
				}
				else if(split[3].equalsIgnoreCase(ContasEnum.CONTAPOUPANCA.name())) {
					ContaPoupanca cp = new ContaPoupanca(split[0], Double.parseDouble(split[1]), Integer.parseInt(split[2]), split[3]);
					listaConta.add(cp);
				}
			
		} else {
			break;
		}
		
		}
		buffRead.close();
	}
}		