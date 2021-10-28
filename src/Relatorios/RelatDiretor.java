package Relatorios;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Conta.Conta;
import Usuarios.Usuario;

public class RelatDiretor {

	public static void informacaoClientes(Conta conta, Usuario u, List<Usuario> listaUsuarios, List<Conta> listaConta)
			throws IOException {
		Collections.sort(listaUsuarios);
		for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.println("\nNome do cliente: " + listaUsuarios.get(i).getNome() + "\nCPF do cliente: "
					+ listaUsuarios.get(i).getCpf() + "\nNumero da agência: " + listaConta.get(i).getAgencia()+ "\n");
		}

		pathInformacaoCliente(conta, u, listaUsuarios, listaConta);
	}

	public static void pathInformacaoCliente(Conta conta, Usuario u, List<Usuario> listaUsuarios, List<Conta> listaConta)
			throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_diretor_" + u.getNome() + EXTENSAO;
		escritorInformacaoCliente(path, conta, u, listaUsuarios, listaConta);
	}

	public static void escritorInformacaoCliente(String path, Conta conta, Usuario u, List<Usuario> listaUsuarios,
			List<Conta> listaConta) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "Relatório: Informações dos clientes";
		buffWrite.append("\n" + linha);
		linha = "Olá, " + u.getNome();
		buffWrite.append(linha + "\n");

		Collections.sort(listaUsuarios);
		for (int i = 0; i < listaUsuarios.size(); i++) {
			linha = " \nNome do cliente: " + listaUsuarios.get(i).getNome() + "\nCPF do cliente: "
					+ listaUsuarios.get(i).getCpf() + "\nNúmero da agência: " + listaConta.get(i).getAgencia() + "\n";
			buffWrite.append("\n" + linha + "\n");
		}
			linha = "Data: " + formatar.format(date);
			buffWrite.append("\n\n" + linha + "\n");


		buffWrite.close();
	}
}