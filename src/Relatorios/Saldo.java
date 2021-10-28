package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Usuarios.Usuario;

public class Saldo {

	public static void pathsaldo(Usuario u, Conta conta) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		final String OPERACAO = "saldo";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + OPERACAO + "_" + u.getNome() + EXTENSAO;
		escritorSaldo(path, conta, u);
	}
	
	public static void escritorSaldo(String path, Conta conta, Usuario u) throws IOException {
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		linha = "Saldo";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + u.getNome();
		buffWrite.append(linha + "\n");
		linha = "Saldo atual: R$ " + conta.getSaldo();
		buffWrite.append(linha + "\n\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
	
}