package View;

import java.io.*;

public class Tabuleiro { 
	
	
	//cria um tabuleiro 10x10
	public static String tabuleiro[][]= new String[10][10];
	
	//define as posicoes dos barcos no tabuleiro
	public static int posicao[][] = new int[10][10];

	public static void zeraPosicao(){
		for(int l=0;l<10;l++){//preenche as linhas com 0//
			for(int c=0;c<10;c++){//preenche as colunas com 0//
				posicao[l][c] = 0;
			}
		}
	}
	
	//Posicao dos submarinos no tabuleiro//
	public static void posicaoDosSubmarinos(){
	//SUBMARINO 1//
	posicao [1][2] = 1;
	//SUBMARINO 2//
	posicao [1][0] = 1;
	//SUBMARINO 3//
	posicao [6][7] = 1;
	//SUBMARINO 4//
	posicao [4][6] = 1;
	//SUBMARINO 5//
	posicao [9][6] = 1;
	}
	//Posicao dos distroyers no tabuleiro//
	public static void posicaoDosDistroyers(){
	//DISTROYER 1//
	posicao [0][6] = 2;
	posicao [0][7] = 2;
	posicao [0][5] = 2;
	posicao [0][4] = 2;
	//DISTROYER 2//
	posicao [5][0] = 2;
	posicao [5][1] = 2;
	posicao [5][2] = 2;
	posicao [5][3] = 2;
	}
	//funcao que define a Posicao dos fragatas no tabuleiro//
	public static void posicaoFragatas(){
	//FRAGATA 1//
	posicao [5][6] = 3;
	posicao [5][7] = 3;
	posicao [5][8] = 3;
	//FRAGATA 2//
	posicao[1][5] = 3;
	posicao[1][6] = 3;
	posicao[1][7] = 3;
	
	}
	//funcao que define a Posicao do torpedeiro no tabuleiro//
	public static void posicaoDoTorpedeiro(){
	//TORPEDEIRO 1//
	posicao[0][0] = 4;
	posicao[0][1] = 4;
	//TORPEDEIRO 2//
	posicao[6][2] = 4;
	posicao[6][3] = 4;
	//TORPEDEIRO 3//
	posicao[8][2] = 4;
	posicao[8][3] = 4;
	
	}
	//funcao que define a Posicao do Porta Aviao no tabuleiro//
	public static void posicaoDoPortaAviao(){
	//PORTA AVIAO//
	posicao[7][3] = 5;
	posicao[7][4] = 5;
	posicao[7][5] = 5;
	posicao[7][6] = 5;
	posicao[7][7] = 5;
	}
	
	public static int lerLinha(){ //le o valor digitado para linha e testa se é um valor valido
		BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
		int Linha=0;
		try {
			System.out.println("Informe a linha ");
			Linha=Integer.parseInt(entrada.readLine());
				if(Linha >=0 && Linha <10){
					return(Linha);
				}else{
					System.out.println("Linha invalida!!!");
					return(lerLinha());
				}
		} catch(Exception e){
			System.out.println("Linha invalida!!!");
			return(lerLinha());
		}
	}

		public static int lerColuna(){ //le o valor digitado para coluna e testa se é um valor valido
			BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
			int Coluna=0;
		
			try {
				System.out.println("Informe a coluna ");
				Coluna=Integer.parseInt(entrada.readLine());
				if(Coluna >=0 && Coluna < 10){
					return(Coluna);
				}else{
					System.out.println("Coluna invalida!!!");
					return(lerColuna());
				}
			} catch(Exception e){
				System.out.println("Coluna invalida!!!");
				return(lerColuna());
			} 
		}
		
	

	public static void inicilizaMatriz(){
		for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9//
			for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9//
				tabuleiro[l][c]=" ";
			}
		}
	}

	public static void imprimeTabuleiro(){ //mostra a matriz no console
		System.out.println("    0   1   2   3   4   5   6   7   8   9"); //numero da coluna
		System.out.println(" _________________________________________");
		
		//System.out.println("A" + "\n" +"B" + "\n" + "C" + "\n" +"D" + "\n" +"E" + "\n" +"F"+ "\n" +"G"+ "\n" +"H" +"\n" +"I" +"\n" +"J" + "\n" ); //Letra da linha
		
		for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9
			
		System.out.print(l + " "); //numero da linhas do lado do tabuleiro
			
			for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9
				System.out.print("|  "+ tabuleiro [l][c]+"");
			}
			System.out.println("|  ");
			System.out.println(" _________________________________________");
		}
	}

	
	public static int verificaPosicao(int col,int lin, int pontuacao){
		int escolha = posicao[lin][col];
		
		
			System.out.println(escolha);
			if(tabuleiro[lin][col] == " "){//se vc ainda n escolheu essa posicao
				pontuacao = pontuacao - 1;
				
			switch(escolha){
			case 0:			
				System.out.println("voce atirou na agua, tente novamente");
				tabuleiro[lin][col] = "-";
				System.out.println("Sua pontuação agora é: " +   pontuacao);			
							break;
			case 1:
				pontuacao+=3;
				System.out.println("voce acertou um submarino");
				tabuleiro[lin][col] = "O";
				System.out.println("Sua pontuação agora é: " +   pontuacao);
				break;
			case 2:
				pontuacao+=3;
				System.out.println("voce acertou um distroyer");
				tabuleiro[lin][col] = "O";
				System.out.println("Sua pontuação agora é: " +   pontuacao);
				break;
			case 3:
				pontuacao+=3;
				System.out.println("voce acertou uma fragata");
				tabuleiro[lin][col] = "O";
				System.out.println("Sua pontuação agora é: " +   pontuacao);
				break;
			case 4:
				pontuacao+=3;
				System.out.println("voce acertou um torpedeiro");
				tabuleiro[lin][col] = "O";
				System.out.println("Sua pontuação agora é: " +   pontuacao);
				break;
			case 5:
				pontuacao+=3;
				System.out.println("voce acertou um porta-avioes");
				tabuleiro[lin][col] = "O";
				System.out.println("Sua pontuação agora é: " +   pontuacao);
				break;
			}
			
		  }
			return pontuacao;
		}
	
	}
	



