package br.ufrn.imd.lp2.io;

import br.ufrn.imd.lp2.domain.DataBase;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* 
		double dfinal[];
		double media=0;
		double dp=0;
		double normal[];
		*/
		System.out.println("AGUARDE A LEITURA DOS ARQUIVOS");
		DataBase db = new DataBase();

		System.out.println("----  Lendo Usu�rios  ----");
		db.lerUser("src/teste/ldap.csv");
		System.out.println("---- Usu�rios finalizados ----");
		System.out.println("");
		
		System.out.println("----  Lendo Devices  ----");
		db.ler("src/br/ufrn/imd/lp2/files/Device.csv");
		System.out.println("---- Devices finalizados ----");
		System.out.println("");
		
		System.out.println("----  Lendo Logons  ----");
		db.ler("src/br/ufrn/imd/lp2/files/logon-completo.csv");
		System.out.println("---- Logons finalizados ----");
		System.out.println("");
		
		
		System.out.println("----  Lendo Https  ----");
		db.ler("src/br/ufrn/imd/lp2/files/http-completo.csv");
		System.out.println("---- Https finalizados ----");
		System.out.println("");
		
		int option = 1;
		Scanner leitor = new Scanner(System.in);
		String input;
		//int teste;
		while(option != 0) {
			System.out.println("\nBEM VINDO AO INSIDER THREAT");
			System.out.println("");
			System.out.println("MENU");
			System.out.println("1 - Buscar Usu�rio");
			System.out.println("2 - Buscar amea�a por cargo");
			System.out.print("Insira o valor de uma opera��o: ");
			option = leitor.nextInt(); 
			leitor.nextLine();
			switch(option) {
				case 1:
					System.out.println("----- BUSCA POR USUARIO -----");
					System.out.println("Insira o ID de um usuario: ");
					input = leitor.nextLine();
					//teste = leitor.nextInt();
					System.out.println("Resultado: ");
					db.userInfo(input);
					break;
				case 2:
					System.out.println("----- BUSCA POR AMEA�A POR CARGO");
					System.out.println("Insira um cargo na empresa: ");
					input = leitor.nextLine();
					System.out.println("Processando os dados");
					System.out.println("Resultado: ");
					db.anomalie(input);
					break;
			}
		}
		//db.seeHist("RES0962");
		//db.userInfo("RES0962");
		//db.anomalie("Administrative Assistant");
		//	histnormal=db.getHistNormal();
		/// Vetor de double do tamanho da quantidade de usu�rios
		/*
		dfinal = new double[db.users.size()];
		for(int j=0;j<db.users.size();j++) {
			for(int i=0;i<24;i++) {
				// Somatorio
				dfinal[j]+=Math.pow(db.users.get(j).getRoot().getHist()[i]-db.getHistMed()[i], 2);
			}
			
			// Raiz do somatorio
			dfinal[j]=Math.sqrt(dfinal[j]);
			//System.out.print(dfinal[j] + " ");
		}
		*/
		/*
		for(int i=0;i<db.users.size();i++) {
			media+=dfinal[i];
		}
			
		media=media/db.users.size();
			
		for(int i=0;i<db.users.size();i++) {
			dp+=Math.pow(dfinal[i]-media,2);
		}
			
		dp=Math.sqrt(dp/db.users.size());
			
		normal = new double[db.users.size()];
		*/
		/*
		for(int i=0;i<db.users.size();i++) {
			//	System.out.println(dfinal[i]);
			//normal[i]=(dfinal[i]-media)/dp;
			System.out.println(Math.abs(dfinal[i])+" ");
		}
		*/
	}
}
