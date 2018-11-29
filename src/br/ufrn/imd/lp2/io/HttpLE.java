package br.ufrn.imd.lp2.io;
/**
 * Classe usada para armazenar linhas do arquivo http.csv
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class HttpLE extends LogEntry {
	
	private String url;
	/**
	 * Construtor do objeto HttpLE
	 * @param id ID da a��o executada
	 * @param date Data da a��o
	 * @param user ID do usu�rio
	 * @param pc Dispositivo que foi usado pelo usu�rio
	 * @param url Url do site acessado pelo usuario
	 */
	public HttpLE(String id, String date, String user, String pc, String url) {
		super(id, date, user, pc);
		this.setUrl(url);
	}
	/**
	 * Retorna url do site acessado
	 * @return Url do site acessado pelo usuario
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Muda o url acessado
	 * @param url Url acessada
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
