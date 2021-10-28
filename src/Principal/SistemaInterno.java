package Principal;


import java.util.ArrayList;
import java.util.List;

import Conta.Conta;
import CriacaoDeDados.EjetarDados;
import Usuarios.Usuario;

public class SistemaInterno {

	public static void main(String[] args) throws Exception {
		
		String path = "./src/criacaoDeDados/Dados.txt";
		
		List<Usuario> listaUsuarios = new ArrayList<>();
		List<Conta> listaConta = new ArrayList<>();
		
		EjetarDados.leitorUsuarios(path, listaUsuarios);
		EjetarDados.leitorContas(path, listaConta);
		
		Principal.menuGeral(listaUsuarios, listaConta);
	}
}