package Controller;
import View.Tabuleiro;


public class Navios{
	
	
	public static void main(String[] args) {
	int linha,coluna, pontuacao;
	pontuacao = 15;
	
	//METODOS QUE INICIALIZAM OS BARCOS//
	Tabuleiro.zeraPosicao();
	Tabuleiro.posicaoDosSubmarinos();
	Tabuleiro.posicaoDosDistroyers();
	Tabuleiro.posicaoFragatas();
	Tabuleiro.posicaoDoTorpedeiro();
	Tabuleiro.posicaoDoPortaAviao();
	
	//METODOS QUE INICIALIZA AS MATRIZES//	
	Tabuleiro.inicilizaMatriz();
	while(pontuacao > 0){
	Tabuleiro.imprimeTabuleiro();
	
	//METODOS QUE PEGAM A LINHA E COLUNA//
	linha = Tabuleiro.lerLinha();
	coluna = Tabuleiro.lerColuna();
	pontuacao = Tabuleiro.verificaPosicao(coluna,linha, pontuacao);
	}
	
	}
	
	
	
	
	
}