package Relatorios;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Usuarios.Usuario;

public class RelatGerente {

	public static int totalDeContasSupervisionadas(Conta conta, Usuario usuario) throws IOException {
		int total = 0;
		if (conta.getAgencia() == 001) {
			total = Conta.getTotalAgencia1();
		} else if (conta.getAgencia() == 002) {
			total = Conta.getTotalAgencia2();
		}

		pathGerente(conta, usuario, total);
		return total;
	}

	public static void pathGerente(Conta conta, Usuario usuario, int total) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_gerente_" + usuario.getNome() + EXTENSAO;
		escritorGerente(path, conta, usuario, total);
	}

	public static void escritorGerente(String path, Conta conta, Usuario u, int total) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "Relatório: Total de contas";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + u.getNome();
		buffWrite.append(linha + "\n");
		linha = "Gerente: " + conta.getCpf() + "\nTotal de contas supervisionadas: " + total;
		buffWrite.append(linha + "\n\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}
}