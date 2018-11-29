package br.ufrn.imd.lp2.io;
/**
 * Classe que armazena a data da a��o feita
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class SystemDate extends AbstractSuper {
	//data bruta, contentendo hora e a data completa
	private String all;
	//dia em que a��o foi realizada
	private String day;
	//hora em que a a��o foi realizada
	private String hour;
	/**
	 * Construtor de objeto SystemDate
	 * @param data Data no formato de string
	 */
	public SystemDate(String data) {
		all = data;
		day = data.substring(0, 10);
		hour = data.substring(11, 13);
	}
	/**
	 * M�todo para retornar o dia da a��o
	 * @return Dia da a��o
	 */
	public String getDate() {
		return day;
	}
	/**
	 * Muda o dia da a��o realizada
	 * @param date Novo dia da a��o realizada
	 */
	public void setDate(String date){
		this.day = date;
	}
	/**
	 * M�todo para retornar a data bruta da a��o
	 * @return Data bruta da a��o
	 */
	public String getAll() {
		return all;
	}
	/**
	 * M�todo para retornar o dia da a��o
	 * @return Dia da a��o
	 */
	public String getDay() {
		return day;
	}
	/**
	 * M�todo para retornar a hora da a��o
	 * @return Hora da a��o
	 */
	public String getHour() {
		return hour;
	}
	/**
	 * Imprime o dia da a��o
	 */
	public void show() {
		System.out.println(getDay());
	}
}
