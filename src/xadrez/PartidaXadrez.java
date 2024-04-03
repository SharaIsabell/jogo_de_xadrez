package xadrez;

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
	
	private void colocarPecaNova(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).converteParaPosicaoXadrez());
	}
	
	public void setupInicial() {
		colocarPecaNova('b', 6, new Torre(tabuleiro, Cor.WHITE));
		colocarPecaNova('e', 8, new Rei(tabuleiro, Cor.BLACK));
		colocarPecaNova('e', 1, new Rei(tabuleiro, Cor.BLACK));
	}

}
