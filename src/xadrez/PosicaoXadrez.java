package xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez {
	private int linha;
	private char coluna;
	
	public PosicaoXadrez(char coluna, int linha) {
		if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException("Erro em PosicaoXadrez. Valores válidos são de a1 até h8");
		}
		this.coluna = coluna;
		this.linha = linha;
	}
	
	public Posicao converteParaPosicao() {
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	protected static PosicaoXadrez converteParaPosicaoXadrez(Posicao posicao) {
		return new PosicaoXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}

	public int getLinha() {
		return linha;
	}

	public char getColuna() {
		return coluna;
	}

	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	
	

}
