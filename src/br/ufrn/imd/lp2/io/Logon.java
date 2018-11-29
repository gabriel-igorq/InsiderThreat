package br.ufrn.imd.lp2.io;
/**
 * Classe que armazena os tipos de a��es da atividade Logon,
 * que podem ser "Logon" ou "Logoff"
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class Logon extends AbstractSuper{
	
	private String activity;
	
	public Logon(){
		
	}
	/**
	 * Construtor de objeto Logon
	 * @param activity A��o de logon ou logoff de um usuario
	 */
	public Logon(String activity) {
		this.setActivity(activity);
	}
	/**
	 * M�todo para retornar atividade de Logon
	 * @return A��o de logon ou logoff de um usuario
	 */
	public String getActivity() {
		return activity;
	}
	/**
	 * M�todo para mudar o tipo de atividade de Logon
	 * @param activity A��o de logon ou logoff de um usuario
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}
	/**
	 * Imprime a a��o de logon ou logoff de um usuario
	 */
	public void show() {
		System.out.println(getActivity());
	}
	
}
