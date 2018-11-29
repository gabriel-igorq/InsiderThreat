package br.ufrn.imd.lp2.io;

import java.util.ArrayList;
/**
 * Classe que representa o n� da arvore
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class Node {
	//valor real (informacao) do n�
	private AbstractSuper value;
	//histograma do n�
	private int hist[];
	//lista de filhos do n�
    private ArrayList<Node> childs;
    /**
	 * Construtor do n�
	 * @param value Valor real(informacao) do n�
	 */
    public Node(AbstractSuper value) {
    	this.setValue(value);
    	setHist(new int[24]);
    	childs = new ArrayList<Node>();
    }
    
    /**
     * Construtor padrao
     */
    public Node() {
    	this.value = new AbstractSuper();
    	setHist(new int[24]);
    	setChilds(new ArrayList<Node>());
    }
    
    /**
	 * Atualiza o histograma do n�, somando 1
	 * @param ts Hora da a��o realizada
	 */
    public void atualizaHist(String ts) {
    	getHist()[Integer.parseInt(ts)]++;
    }
    
    /**
	 * Retorna o histograma do n�
	 * @return histograma do n�
	 */
	public int[] getHist() {
		return hist;
	}
	
	/**
	 * Muda o histograma do n�
	 * @param hist Novo histograma
	 */
	public void setHist(int hist[]) {
		this.hist = hist;
	}
	
	/**
	 * Retorna o valor real(informacao) do n�
	 * @return valor do n�
	 */
	public AbstractSuper getValue() {
		return value;
	}
	
	/**
	 * Muda o valor real(informacao) do n�
	 * @param valor Novo valor real
	 */
	public void setValue(AbstractSuper valor) {
		this.value = valor;
	}
	
	/**
	 * Retorna uma lista com todos os filhos do n�
	 * @return lista com os filhos do n�
	 */
	public ArrayList<Node> getChilds() {
		return childs;
	}
	
	/**
	 * Muda os filhos do n�
	 * @param childs Novos filhos do n�
	 */
	public void setChilds(ArrayList<Node> childs) {
		this.childs = childs;
	}
	
	/**
	 * Retorna o numero de filhos do n�
	 * @return numero de filhos do n�
	 */
	public int getNumberOfChildren() {
        return getChilds().size();
    }
	
	/**
     * Consulta se o n� possui filhos ou n�o
     * @return True se houver filhos False caso contrario
     */
    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }
    
    /**
	 * Retorna o filho correspondente a posicao index da lista de flihos do n�
	 * @param index Posicao do filho requerida
	 * @return filho correspondente a posicao index da lista de flihos do n�
	 */
    public Node getChildAt(int index) throws IndexOutOfBoundsException {
        return childs.get(index);
    }
    
    /**
     * Imprime o histograma do n�
     */
    public void printHist() {
    	for(int i = 0; i < 24; i++) {
    		System.out.print(hist[i]+ " ");
    	}
    }
}
