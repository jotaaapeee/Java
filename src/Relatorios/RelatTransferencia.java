package Relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Conta.Conta;
import Usuarios.Usuario;

public class RelatTransferencia {

	public static void pathTransferencia(Conta conta, double valor, Usuario usuario, Usuario destinatario)
			throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_transferencia_" + usuario.getNome() + EXTENSAO;
		escritorTransferencia(path, conta, usuario, valor, destinatario);
	}

	public static void escritorTransferencia(String path, Conta conta, Usuario u, double valor, Usuario destinatario)
			throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "Relatório de Transferência";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + u.getNome();
		buffWrite.append(linha + "\n");
		linha = "Agência: " + conta.getAgencia() + "\nValor transferido: R$ " + valor + 
				"\nNome do destinatário: " + destinatario.getNome() + "\nCPF do destinatário: "
				+ destinatario.getCpf() + "\n\nSaldo atual: R$ " + conta.getSaldo();
		buffWrite.append(linha + "\n\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}
}