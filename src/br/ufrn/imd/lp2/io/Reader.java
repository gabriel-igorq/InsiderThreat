package br.ufrn.imd.lp2.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {

	BufferedReader arquivoDevice;

	public BufferedReader leitura(String localDoArquivo) throws FileNotFoundException{
		arquivoDevice = new BufferedReader(new FileReader(localDoArquivo));
		return arquivoDevice;
	}
	
}