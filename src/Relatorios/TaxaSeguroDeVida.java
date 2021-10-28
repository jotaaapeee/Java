package Relatorios;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Usuarios.Usuario;

public class TaxaSeguroDeVida {

	public static void pathSeguro(Conta conta, Usuario usuario) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_tributacao_seguro_de_vida_" + usuario.getNome() + EXTENSAO;
		escritorRendimento(path, conta, usuario);
	}

	public static void escritorRendimento(String path, Conta conta, Usuario u) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "Tributação do seguro de vida";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + u.getNome();
		buffWrite.append(linha + "\n");
		linha = "Agência: " + conta.getAgencia() + "\nValor do tributo: R$ " + conta.getvSeguro();
		buffWrite.append(linha + "\n\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}