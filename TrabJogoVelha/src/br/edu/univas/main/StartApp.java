package br.edu.univas.main;

import java.util.Scanner;

public class StartApp {

	static char[][] jogoVelha = new char[3][3];
	static int linhaS = 0, coluna = 0;
	static char linha;

	public static void main(String[] args) {

		Scanner reading = new Scanner(System.in);

		System.out.println("Jogador 1 - Digite seu nome:");
		String nome1 = reading.nextLine();

		System.out.println("Jogador 2 - Digite seu nome:");
		String nome2 = reading.nextLine();
		System.out.println();

		System.out.println(nome1 + " = X");
		System.out.println(nome2 + " = O");
		System.out.println();

		boolean ganhou = false;
		int jogada = 1;
		char sinal;

		while (!ganhou) {

			if (jogada % 2 == 1) {

				System.out.println(nome1 + " Escolha linha e coluna de 1 até 3");
				System.out.println();
				sinal = 'X';
			} else {

				System.out.println(nome2 + " Escolha linha e coluna de 1 até 3");
				System.out.println();
				sinal = 'O';
			}
			linha1();
			coluna1();

			linhaS--;
			coluna--;
			if (jogoVelha[linhaS][coluna] == 'X' || jogoVelha[linhaS][coluna] == 'O') {
				System.out.println("Posição já usada, tente novamente");
			} else {
				jogoVelha[linhaS][coluna] = sinal;
				jogada++;
			}

			tabuleiro();

			if ((jogoVelha[0][0] == 'X' && jogoVelha[0][1] == 'X' && jogoVelha[0][2] == 'X')
					|| (jogoVelha[1][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[1][2] == 'X')
					|| (jogoVelha[2][0] == 'X' && jogoVelha[2][1] == 'X' && jogoVelha[2][2] == 'X')
					|| (jogoVelha[0][0] == 'X' && jogoVelha[1][0] == 'X' && jogoVelha[2][0] == 'X')
					|| (jogoVelha[0][1] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][1] == 'X')
					|| (jogoVelha[0][2] == 'X' && jogoVelha[1][2] == 'X' && jogoVelha[2][2] == 'X')
					|| (jogoVelha[0][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][2] == 'X')
					|| (jogoVelha[0][2] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][0] == 'X')) {
				ganhou = true;
				System.out.println("Parabéns, " + nome1 + " ganhou!");

			} else if ((jogoVelha[0][0] == 'O' && jogoVelha[0][1] == 'O' && jogoVelha[0][2] == 'O')
					|| (jogoVelha[1][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[1][2] == 'O')
					|| (jogoVelha[2][0] == 'O' && jogoVelha[2][1] == 'O' && jogoVelha[2][2] == 'O')
					|| (jogoVelha[0][0] == 'O' && jogoVelha[1][0] == 'O' && jogoVelha[2][0] == 'O')
					|| (jogoVelha[0][1] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][1] == 'O')
					|| (jogoVelha[0][2] == 'O' && jogoVelha[1][2] == 'O' && jogoVelha[2][2] == 'O')
					|| (jogoVelha[0][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][2] == 'O')
					|| (jogoVelha[0][2] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][0] == 'O')) {
				ganhou = true;
				System.out.println("Parabéns, " + nome2 + " ganhou!");
			} else if (jogada > 9) {
				ganhou = true;
				System.out.println("Ninguém ganhou essa partida.");
			}

		}
	}

	public static void tabuleiro() {

		for (int i = 0; i < jogoVelha.length; i++) {
			for (int j = 0; j < jogoVelha[i].length; j++) {
				System.out.print(jogoVelha[i][j] + " | ");
			}
			System.out.println();
		}
	}

	public static void linha1() {

		Scanner reading = new Scanner(System.in);
		boolean linhaValida = false;
		while (!linhaValida) {
			System.out.println("Entre com a linha a, b ou c");
			System.out.println();
			linha = reading.next().charAt(0);
			if (linha == 'a')
				linhaS = 1;
			if (linha == 'b')
				linhaS = 2;
			if (linha == 'c')
				linhaS = 3;
			if (linha == 'a' || linha == 'b' || linha == 'c') {
				linhaValida = true;
			} else {
				System.out.println("Entrada inválida, tente novamente");
			}
		}
	}

	public static void coluna1() {

		Scanner reading = new Scanner(System.in);
		boolean colunaValida = false;
		while (!colunaValida) {
			System.out.println("Entre com a coluna 1, 2 ou 3");
			System.out.println();
			coluna = reading.nextInt();
			if (coluna >= 1 && coluna <= 3) {
				colunaValida = true;
			} else {
				System.out.println("Entrada inválida, tente novamente");
			}
		}
	}
}