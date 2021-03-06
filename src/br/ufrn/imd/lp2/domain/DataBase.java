package br.ufrn.imd.lp2.domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

import br.ufrn.imd.lp2.io.*;

/**
 * Classe que armazena todos os dados dos usuarios, armazenando uma lista
 * de arvores de usuarios
 * @author Gabriel Igor e Victor Hugo
 * @version 2018.29.11
 */

public class DataBase {
	// Lista de arvores de usuarios
	public ArrayList<Tree>users;

	// DataBase Singleton
	public static final DataBase databaseSingleton = new DataBase();
	
    /**
     * Cria um objeto DataBase unico ja que o projeto foi implementado
     * usando-se o padrao de projeto Singleton
     */
	private DataBase() {
		users = new ArrayList<Tree>();
	}
	
    /**
     * Metodo estatico que garante que existe um unico objeto DataBase
     * @return DataBase unica criada
     */
	public static DataBase getInstance() {
		return databaseSingleton;
	}
	
	/**
	 * Calcula o histograma media dos usuarios daquela funcao
	 * @param funcao Funcao dos usuarios a serem analisados
	 * @return O histograma media dos usuarios
	 */
	public int[] getHistMed(String funcao) {
		int histmedio[]=new int[24];
		int aux[]=new int[24];
		for(int i=0;i<users.size();i++) {
			User member = (User) users.get(i).getRoot().getValue();
			if(member.getRole().equals(funcao)) {
			for(int j=0;j<24;j++) {
				aux[j]+=users.get(i).getRoot().getHist()[j];
			}
			}
		}
		for (int i=0;i<24;i++) {
			histmedio[i]=aux[i]/users.size();
		}
		return histmedio;
	}
	
	/**
	 * Adiciona usuarios na base de dados
	 * @param employee Usuario a ser adicionado na base de dados
	 */
	public void addUsers(User employee) {
		Node aux;
		boolean existe= false;
		for(int i=0;i<users.size();i++) {
			aux=users.get(i).getUserChild(users.get(i).getRoot(), employee.getId()); 
			if(aux!=null) {
				existe=true;
			}
		}
			
		if(existe==false) {
			Node userRoot = new Node(employee);
			Tree tree = new Tree(userRoot);
			users.add(tree);
		}
	}
	
	/**
	 * Imprime a Arvore de usuario
	 * @param id Usuario cujas informacoes deseja-se ver
	 */
	public void userInfo(String id) {
		boolean existe = false;
		for(int i = 0; i < users.size(); i++) {
			User member = (User) users.get(i).getRoot().getValue();
			if(member.getId().equals(id)) {
				existe = true;
				member.show();
				ArrayList<Node> dates = users.get(i).getRoot().getChilds();
				for(Node date: dates) {
					SystemDate data = (SystemDate) date.getValue();
					data.show();
					ArrayList<Node> pcs = date.getChilds();
					for(Node pc: pcs) {
						PC computer = (PC) pc.getValue();
						computer.show();
						ArrayList<Node> acts = pc.getChilds();
						for(Node act: acts) {
							Action action = (Action) act.getValue();
							action.show();
							ArrayList<Node> activities = act.getChilds();
							for(Node end: activities) {
								if(end.getValue() instanceof Device) {
									Device dvc = (Device) end.getValue();
									dvc.show();
								}
								else if(end.getValue() instanceof HTTP) {
									HTTP site = (HTTP) end.getValue();
									site.show();
								}
								else if(end.getValue() instanceof Logon) {
									Logon site = (Logon) end.getValue();
									site.show();
								}
							}
						}
					}
				}
			}
		}
		if(existe == false) {
			System.out.println("ID invalido");
		}
	}
	
	/**
	 * Permite visualizar o histograma de um usuario
	 * @param user Usuario o qual deseja-se ver o histograma
	 */
	public void seeHist(String user) {
		boolean valido = false;
		for(Tree usuario: users) {
			//AbstractSuper aux = usuario.getRoot().getValue();
			User u = (User) usuario.getRoot().getValue();
			if(u.getId().equals(user)) {
				usuario.getRoot().printHist();
				valido = true;
			}
		}
		if(valido == false) {
			System.out.println("ID inexistente ou inválido");
		}
	}
	
	/**
	 * Metodo para ler o arquivo contendo os usuarios sem valores duplicados
	 * @param nomearquivo Nome do arquivo contendo a lista de usuarios
	 */
	public void lerUser(String nomearquivo) {
		Scanner leitor;
		Reader arquivo = new Reader();
		String[] teste;
		try {
			leitor = new Scanner(arquivo.leitura(nomearquivo));	
			String linha = new String();
			leitor.nextLine();
			
			while(leitor.hasNext()){
				linha = leitor.nextLine();
				teste = linha.split(",");
				
				User de=new User(teste[0],teste[1],teste[2],teste[3],teste[4]);
				
				addUsers(de);	
			}
			leitor.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para ler o arquivo de atividades dos usuarios
	 * @param nomearquivo Nome do arquivo contendo as atividades
	 */
	public void ler(String nomearquivo) {
		Scanner leitor;
		Reader arquivo = new Reader();
		String[] teste;
		LogEntry de = new LogEntry();
		try {
			leitor = new Scanner(arquivo.leitura(nomearquivo));	
			String linha = new String();
			leitor.nextLine();
			
			while(leitor.hasNext()){
				linha = leitor.nextLine();
				teste = linha.split(",");
				
				if(nomearquivo.equals("src/br/ufrn/imd/lp2/files/device.csv"))
					de=new DeviceLE(teste[0],teste[1],teste[2],teste[3],teste[4]);
				else if(nomearquivo.equals("src/br/ufrn/imd/lp2/files/logon.csv"))
					de=new LogonLE(teste[0],teste[1],teste[2],teste[3],teste[4]);
				else if(nomearquivo.equals("src/br/ufrn/imd/lp2/files/http.csv"))
					de=new HttpLE(teste[0],teste[1],teste[2],teste[3],teste[4]);
				
				SystemDate date = new SystemDate(de.getDate());
				
				for(int i = 0; i < users.size(); i++) {
					User member = (User) users.get(i).getRoot().getValue();
					if(member.getId().equals(de.getUser())) {
						users.get(i).getRoot().atualizaHist(date.getHour());
						users.get(i).addLE(de, date.getHour());
						break;
					}
				}
			}
			leitor.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Verifica os usuarios de mesma funcao que tem comportamento suspeito
	 * @param funcao Funcao dos usuarios a serem analisados
	 */
	public void anomalie(String funcao) {
		double dfinal[]  = new double[users.size()];
		int aux2=0;
		int[] histMedFinal=new int[24];
		histMedFinal=getHistMed(funcao);
		for(int k = 0; k < users.size(); k++) {
			User member = (User)  users.get(k).getRoot().getValue();
			if(member.getRole().equals(funcao)) {
				aux2++;
				for(int i=0;i<24;i++) {
					// Somatorio
					dfinal[k]+=Math.pow(users.get(k).getRoot().getHist()[i]-histMedFinal[i], 2);
				}
					
				// Raiz do somatorio
				dfinal[k]=Math.sqrt(dfinal[k]);
			}
		}
		if(aux2 == 0) {
			System.out.println("Cargo n�o existente ou inv�lido");
		} else {
			double normal[]=new double[aux2];
			aux2=0;
			for(int i=0;i<users.size();i++) {
				if(dfinal[i]!=0){
					normal[aux2]=dfinal[i];
					aux2++;
				}
			}
			double mediana,q1,q3,interq,in1,in2;
			Arrays.sort(normal);
			if(aux2%2!=0) {
				mediana=(normal[aux2/2]+normal[(aux2/2)+1])/2;
				q1=(normal[aux2/4]+normal[(aux2/4)+1])/2;
				q3=(normal[3*aux2/4]+normal[(3*aux2/4)+1])/2;
			}else {
				mediana=normal[aux2/2];
				q1=normal[aux2/4];
				q3=normal[3*aux2/4];
			}
			interq=(q3-q1)*1.5;
			in1=q3+interq;
			in2=q1-interq;
			User t1;
			
			for(int i=0;i<aux2;i++) {
				if(normal[i]<in2 || normal[i]>in1) {
					System.out.print("PEGUEI!!  ");
					for(int z=0;z<users.size();z++) {
						if(dfinal[z]==normal[i]) {
							t1=(User)users.get(z).getRoot().getValue();
							System.out.println("O USUARIO COM ID "+t1.getId() +" E COM NOME "+t1.getName()+"  ");
						}
					}
				}
			}
		}
				
	}
}

