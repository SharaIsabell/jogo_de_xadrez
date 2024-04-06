package tabuleiro;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro criando tabuleiro: deve existir pelo menos uma linha e uma coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}
	
	public Peca peca(int linha, int coluna) { //retorna a peça que está na posição dada
		if(!posicaoExiste(linha, coluna)) {
			throw new TabuleiroException("Posição não existe no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) { //retorna a peça que está na posição dada
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posição não existe no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocarPeca(Peca peca, Posicao posicao) { //coloca a peça dada na posição também dada
		if(temUmaPeca(posicao)) {
			throw new TabuleiroException("Já existe uma peça na posição " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca; //coloca a peça na matriz de peças
		peca.posicao = posicao; //aponta a posição da peça para a posiçao dada
	}
	
	public Peca removerPeca(Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posição não existe no tabuleiro");
		}
		if(peca(posicao) == null) { // se não tiver uma peça nessa posição retorna null
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null; //aponta a posição da peça para null
		pecas[posicao.getLinha()][posicao.getColuna()] = null; //substitui a peça na matriz de peças por null
		return aux;
	}
	
	private boolean posicaoExiste(int linha, int coluna) { //retorna se a posição existe no tabuleiro
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean posicaoExiste(Posicao posicao) { //retorna se a posição existe no tabuleiro
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean temUmaPeca(Posicao posicao) { //retorna se na posição dada há uma peça
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posição não existe no tabuleiro");
		}
		return peca(posicao) != null;
	}
	
	//Getters and setters
	
	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

}
