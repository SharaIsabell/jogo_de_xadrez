package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Main {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		PartidaXadrez partida = new PartidaXadrez();
		
		while(true) {
			UI.printTabuleiro(partida.getPecas());
			
			System.out.println();
			System.out.print("Inicial: ");
			PosicaoXadrez inicial = UI.lerPosicaoXadrez(leitor);
			
			System.out.println();
			System.out.print("Desejada: ");
			PosicaoXadrez desejada = UI.lerPosicaoXadrez(leitor);
			
			PecaXadrez pecaCapturada = partida.moverPeca(inicial, desejada);
			System.out.println();
		}
	}
}
