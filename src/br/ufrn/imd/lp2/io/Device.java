package br.ufrn.imd.lp2.io;

/**
 * Classe que armazena os tipos de a��es da atividade Device,
 * que podem ser "Connect" ou "Disconnect"
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class Device extends AbstractSuper {
	// A��o de conex�o ou desconex�o de um pendrive
	private String activity;
	
	/**
	 * Construtor de objeto Device
	 * @param activity A��o de conex�o ou desconex�o de um pendrive
	 */
	public Device(String activity) {
		this.setActivity(activity);
	}

	/**
	 * M�todo para retornar atividade de Device
	 * @return A��o de conex�o ou desconex�o de um pendrive
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * M�todo para mudar o tipo de atividade de Device
	 * @param activity A��o de conex�o ou desconex�o de um pendrive
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	/**
	 * Imprime a a��o de conex�o ou desconex�o de um pendrive
	 */
	public void show() {
		System.out.println(getActivity());
	}
}
