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
		colocarPecaNova('c', 1, new Torre(tabuleiro, Cor.BRANCA));
		colocarPecaNova('c', 2, new Torre(tabuleiro, Cor.BRANCA));
		colocarPecaNova('d', 2, new Torre(tabuleiro, Cor.BRANCA));
		colocarPecaNova('e', 2, new Torre(tabuleiro, Cor.BRANCA));
		colocarPecaNova('e', 1, new Torre(tabuleiro, Cor.BRANCA));
		colocarPecaNova('d', 1, new Rei(tabuleiro, Cor.BRANCA));

		colocarPecaNova('c', 7, new Torre(tabuleiro, Cor.PRETA));
		colocarPecaNova('c', 8, new Torre(tabuleiro, Cor.PRETA));
		colocarPecaNova('d', 7, new Torre(tabuleiro, Cor.PRETA));
		colocarPecaNova('e', 7, new Torre(tabuleiro, Cor.PRETA));
		colocarPecaNova('e', 8, new Torre(tabuleiro, Cor.PRETA));
		colocarPecaNova('d', 8, new Rei(tabuleiro, Cor.PRETA));
	}

}
