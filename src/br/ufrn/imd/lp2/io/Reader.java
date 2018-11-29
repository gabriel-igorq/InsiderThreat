package br.ufrn.imd.lp2.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 * Classe usada para leitura do arquivo
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class Reader {

	BufferedReader arquivoDevice;
	/**
	 * Consulta se o arquivo � leg�vel, caso contrario dispara uma exce��o
	 * @param localDoArquivo local do arquivo a ser lido
	 * @return arquivo leg�vel na forma de BufferedReader
	 */
	public BufferedReader leitura(String localDoArquivo) throws FileNotFoundException{
		arquivoDevice = new BufferedReader(new FileReader(localDoArquivo));
		return arquivoDevice;
	}
	
}
