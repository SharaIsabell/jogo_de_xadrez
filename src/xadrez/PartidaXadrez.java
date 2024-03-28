package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		setupInicial();
	}
	
	public PecaXadrez[][] getPecas(){ //retornando as peças do tabuleiro
		PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][ tabuleiro.getColunas()];
		for(int i = 0; i < tabuleiro.getLinhas(); i++) {
			for(int j = 0; j < tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecaXadrez) tabuleiro.peca(i, j); //fazendo o downcasting de Peca para PecaXadrez em cada peça
			}
		}
		return matriz;
	}
	
	public void setupInicial() {
		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.WHITE), new Posicao(2, 1));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BLACK), new Posicao(0, 4));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BLACK), new Posicao(7, 4));
	}

}
