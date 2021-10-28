package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Usuarios.Usuario;

public class RelatSaque {
	
	public static void pathSaque(Conta conta, Usuario usuario, double valor) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_saque_" + usuario.getNome() + EXTENSAO;
		escritorSaque(path, conta, usuario, valor);	
	}
	
	public static void escritorSaque(String path, Conta conta, Usuario u, double valor) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "Relatório de saque";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + u.getNome();
		buffWrite.append(linha + "\n");
		linha = "Agência: " + conta.getAgencia() + "\nValor sacado: R$ " + valor + "\nSaldo: R$ " + conta.getSaldo();
		buffWrite.append(linha + "\n\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}