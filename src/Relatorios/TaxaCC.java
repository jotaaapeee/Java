package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Conta.Taxas;
import Usuarios.Usuario;

public class TaxaCC {

	public static void pathTributacao(Usuario u, Conta conta) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		final String OPERACAO = "tributacao_da_cc";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + OPERACAO + "_" + u.getNome() + EXTENSAO;
		escritorTributacao(path, conta, u);
	}

	public static void escritorTributacao(String path, Conta conta, Usuario u) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "Tributação da Conta Corrente";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + u.getNome();
		buffWrite.append(linha + "\n");
		linha = "Você gastou um total de R$ " + conta.getTotalTributos();
		buffWrite.append(linha + "\n\n");
		linha = "No nosso banco, a tributação para cada operação realizada é cobrado:\n" + "Para o saque: R$ " + Taxas.saque
				+ "\nPara o depósito: R$ " + Taxas.deposito + "\nPara as transferências: R$ " + Taxas.transferencia;
		buffWrite.append(linha + "\n\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

}