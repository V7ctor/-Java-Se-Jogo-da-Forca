package Aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Inicializacao {

	public static void main(String[] args) {
		
		System.out.println("Bem vindo a Forca");
		
		Scanner sc = new Scanner(System.in);
		
		List<String> listaPalavras = new ArrayList<String>();
		
		System.out.println("Escolha a dificuldade: ");
		System.out.println("1 - Fácil");
		System.out.println("2 - Médio");
		System.out.println("3 - Difícil");
		System.out.println("4 - Extremamente Difícil");
		System.out.print("Dificuldade: ");
		Integer dificuldade = sc.nextInt();
		
		if (dificuldade == 1) {
			listaPalavras.add("macaco");
			listaPalavras.add("torre");
			listaPalavras.add("centurao");
		} else if ((dificuldade == 2)){
			listaPalavras.add("contingencia");
			listaPalavras.add("meritocracia");
			listaPalavras.add("possibilidade");
		} else if ((dificuldade == 3)){
			listaPalavras.add("paralelepipedo");
			listaPalavras.add("meritocracia");
			listaPalavras.add("possibilidade");
		} else if ((dificuldade == 4)){
			listaPalavras.add("histerossalpingografico");
			listaPalavras.add("dacriocistossiringotomia");
			listaPalavras.add("hipopotomonstrosesquipedaliofobia");
			listaPalavras.add("oftalmotorrinolaringologista");
			listaPalavras.add("anticonstitucionalissimamente");
		} else if ((dificuldade > 4)) {
			System.out.println("Valor de dificuldade inválido");
		}
		
		
		Random random = new Random();
		
		int posicaoAleatoria = random.nextInt(listaPalavras.size());
		
		String palavra = listaPalavras.get(posicaoAleatoria);
		
		
		char[] vetorLetras = new char[palavra.length()];
		
		for (int j = 0; j < palavra.length(); j++) {
			vetorLetras[j] = palavra.charAt(j);
		}
		
		/*
		for (char c : vetorLetras) {
			System.out.print(c);
		}
		*/
		
		System.out.println();
		
		System.out.println("Dica: A palavra possui " + vetorLetras.length + " letras");
		System.out.println();
		
		char[] tabuleiro = new char[palavra.length()];
		
		for (int k = 0; k < tabuleiro.length; k++) {
			tabuleiro[k] = '_';
		}
				
		for (int i = 10; i >= 0; i--) {
			
			if (i == 0) {
				System.out.println("Voce Perdeu");
				System.out.println("A resposta certa era: ");
				for (char v : vetorLetras) {
					System.out.print(v);
				}
				break;
			}
			
			System.out.println(i + " Chances restantes: ");
			
			for (char t : tabuleiro) {
				System.out.print(t + " ");
			}
			
			System.out.println();
			
			if (i <= 3) {
				System.out.println("Deseja chutar a palavra ? (S/N)");
				System.out.print("Aviso!!! se você errar, perderá o jogo, sim ou não: ");
				char escolha = sc.next().toUpperCase().charAt(0);
				
				if (escolha == 'S') {
					System.out.print("Digite a palavra: ");
					String palavraArriscar = sc.next();
					if (palavraArriscar.equals(palavra)) {
						System.out.println("Você venceu!!!, a palavra era: " + palavraArriscar);
						break;
					} else if(!palavraArriscar.equals(palavra)) {
						System.out.println("Você perdeu!!!, a palavra era: " + palavra);
					}
				}
			}
				
			System.out.print("Entre com uma letra: ");
			String letra = sc.next().toLowerCase();
			
			boolean confirmador = false;
			
			for (int j = 0; j < tabuleiro.length; j++) {
				if (vetorLetras[j] == letra.charAt(0)) {
					tabuleiro[j] = vetorLetras[j];
					confirmador = true;
				}
				 
			}
			
			StringBuilder palavraUsuario = new StringBuilder();
			
			for (Character item: tabuleiro) {
				palavraUsuario.append(Character.toString(item.charValue()));
			}
						
			if (palavra.equals(palavraUsuario.toString())) {
				System.out.println("Você venceu!!!, a palavra era: " + palavraUsuario);
				break;
			}
			
			System.out.println();
			
		}
		
		sc.close();
	}

}
