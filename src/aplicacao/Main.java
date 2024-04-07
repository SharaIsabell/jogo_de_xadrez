package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Main {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		PartidaXadrez partida = new PartidaXadrez();
		
		while(true) {
			try {
				UI.clearScreen(); // limpando a tela toda vez que encerrar a jogada para não ficar muito poluído
				
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
			catch(XadrezException e) {
				System.out.println(e.getMessage());
				leitor.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				leitor.nextLine();
			}
		}
	}
}
