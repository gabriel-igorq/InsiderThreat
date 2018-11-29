package br.ufrn.imd.lp2.io;
/**
 * Classe usada para armazenar linhas do arquivo logon.csv
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class LogonLE extends LogEntry{
	private String login;
	/**
	 * Construtor do objeto LogonLE
	 * @param id ID da a��o executada
	 * @param date Data da a��o
	 * @param user ID do usu�rio
	 * @param pc Dispositivo que foi usado pelo usu�rio
	 * @param login Infomacao do login(logon ou logoff) do usuario
	 */
	public LogonLE(String id, String date, String user, String pc, String login) {
		super(id, date, user, pc);
		this.setLogin(login);
	}
	/**
	 * Retorna o status de login feito pelo usuario
	 * @return login Infomacao do login(logon ou logoff) do usuario
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Muda a a��o de login 
	 * @param login A��o de login(logon ou logoff)
	 */
	public void setLogin(String login) {
		this.login = login;
	}
}
