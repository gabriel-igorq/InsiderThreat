package br.ufrn.imd.lp2.io;

/**
 * Classe usada para armazenar linhas do arquivo device.csv
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class DeviceLE extends LogEntry{
	// Atividade de conex�o ou desconex�o de um pendrive
	private String connection;
	
	/**
	 * Construtor do objeto DeviceLE
	 * @param id ID da a��o executada
	 * @param date Data da a��o
	 * @param user ID do usu�rio
	 * @param pc Dispositivo que foi usado pelo usu�rio
	 * @param connection A��o de conex�o ou desconex�o de um pendrive
	 */
	public DeviceLE(String id, String date, String user, String pc, String connection) {
		super(id, date, user, pc);
		this.setConnection(connection);
	}

	/**
	 * Retorna a atividade de conex�o ou desconex�o de um pendrive
	 * @return Atividade do usu�rio com o pendrive
	 */
	public String getConnection() {
		return connection;
	}

	/**
	 * Muda o tipo da atividade com o pendrive
	 * @param connection Atividade de conex�o ou desconex�o do pendrive
	 */
	public void setConnection(String connection) {
		this.connection = connection;
	}
}

