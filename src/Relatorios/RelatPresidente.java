package Relatorios;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Conta.Conta;
import Usuarios.Usuario;

public class RelatPresidente {

	public static Double totalDeCapital(Conta conta, Usuario usuario, List<Conta> listaConta) throws IOException {
		double capitalTotal = 0;
		for (int i = 0; i < listaConta.size(); i++) {
			capitalTotal += listaConta.get(i).getSaldo() + listaConta.get(i).getTotalTributos();
		}
		pathCapital(conta, usuario, capitalTotal);
		return capitalTotal;
	}

	public static void pathCapital(Conta conta, Usuario usuario, double capital) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_presidente_" + usuario.getNome() + EXTENSAO;
		escritorCapital(path, conta, usuario, capital);
	}

	public static void escritorCapital(String path, Conta conta, Usuario u, double capital) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "Relatório: Total de capital no banco";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + u.getNome();
		buffWrite.append(linha + "\n");
		linha = "O capital total presente no banco é de: R$  " + capital;
		buffWrite.append(linha + "\n\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}