package Exer_01;

import java.text.Collator;
import java.util.Locale;

public class Exer01 {
	
	/*Implementar um dos métodos de ordenação para ordenar a estrutura com duas palavras (String), 
	tipo um dicionário com a palavra e a tradução (Português/Inglês). 
	Usar a linguagem JAVA para essa tarefa. Colocar no teste a opção de ordenar por qualquer uma das línguas.*/
	
	public static void ordenarPor(String matriz[][]){//selection sort
		int min;
		String aux1,aux2;

		for(int i = 0;i < matriz.length-1;i++) {
			min = i;
			for(int j = i+1;j < matriz.length;j++) {
				Collator cot = Collator.getInstance(new Locale("pt", "BR"));
				cot.setStrength (Collator.PRIMARY);
				int resp = cot.compare(matriz[min][0],matriz[j][0]);
				if(resp == 0) {
					System.out.println("\nErro.\nMesma palavra");
					break;
				}else if(resp > 0) {
					min = j;	
				}
			}
			aux1 = matriz[i][0]; 
			aux2 = matriz[i][1];
			matriz[i][0] = matriz[min][0]; 
			matriz[i][1] = matriz[min][1];
			matriz[min][0] = aux1;
			matriz[min][1] = aux2;
		}
	}
	public static void ordenarIng(String matriz[][]) {// selection sort
		int min;
		String aux1,aux2;
		for(int i = 0;i < matriz.length-1;i++) {
			min = i;
			for(int j = i+1;j < matriz.length;j++) {
				int resp = matriz[min][1].compareToIgnoreCase(matriz[j][1]);
				if(resp == 0) {
					System.out.println("Erro.\nMesma palavra.");
					break;
				}
				if(resp > 0) {
					min = j;	
				}
			}
			aux1 = matriz[i][0]; 
			aux2 = matriz[i][1];
			matriz[i][0] = matriz[min][0]; 
			matriz[i][1] = matriz[min][1];
			matriz[min][0] = aux1;
			matriz[min][1] = aux2;
		} 
		for (int i = 0; i < matriz.length; i++) {//trocar posição na matriz
			String arm = matriz[i][0];
			matriz[i][0] = matriz[i][1];
			matriz[i][1] = arm;
			
		}
	}
	public static void exibirMatriz(String matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(" "+ matriz[i][j] +" ");
				if(j == 0) {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		String [][] dic = { {"cachorro","dog"},
                {"gato", "cat"},
                {"teclado", "keyboard"},
                {"rato", "mouse"},
                {"abacaxi","pineapple"},
                {"faca", "knife"},
                {"mar", "sea"},
                {"sabonete", "soap"},
                {"verde","green"},
                {"azul","blue"},
                {"vermelho","red"},
                {"branco","white"},
                {"livro","book"},
                {"caneta","pen"},
                {"bicicleta","bike"},
                {"jogo","game"},
                {"caixa","box"},
                {"telefone","phone"},
                {"carro","car"},
                {"cadeira","chair"},
                {"manual","manual"},
                {"osso","bone"},
                {"outono","fall"},
                {"inverno","winter"},
                {"porta","door"},
                {"veleiro","yacht"},
                {"ilha","island"},
                {"zebra","zebra"},
                {"zero","zero"},
                {"preto", "black"}
               };
	
		System.out.println("Antes da ordenação: ");
		exibirMatriz(dic);
		
		ordenarPor(dic);
		//ordenarIng(dic);
		
		System.out.println("\nDepois da ordenação: ");
		exibirMatriz(dic);
		
	}
}	