package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Conta.ContaPoupanca;
import Usuarios.Usuario;

public class RendPoupanca {
	public static void pathRendimento(Conta conta, Usuario usuario, double valor, int dias) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_rendimento_poupanca_" + usuario.getNome() + EXTENSAO;
		escritorRendimento(path, conta, usuario, valor, dias);
	}

	public static void escritorRendimento(String path, Conta conta, Usuario u, double valor, int dias)
			throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		buffWrite.append(linha + "\n");
		linha = "Simulação de rendimento";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + u.getNome();
		buffWrite.append(linha + "\n");
		linha = "Agência: " + conta.getAgencia() + "\nValor de aplicação: " + valor + "\nQuantidade de dias: " + dias
				+ "\nRendimento previsto: " + ((ContaPoupanca) conta).getValorRendimento();
		buffWrite.append(linha + "\n\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}

}