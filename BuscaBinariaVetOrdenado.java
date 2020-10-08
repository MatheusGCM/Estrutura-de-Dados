package Exer_03;

import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;

public class Exer03 {

	/*Implementar em JAVA uma busca binária em vetor ordenado. 
	Essa busca deve procurar por uma palavra no vetor de palavras (português/Inglês) usado na questão 1. 
	Usar o método de ordenação da questão 1 para gerar o vetor ordenado. Fazer uma cópia do vetor para que possa ser ordenado nos dois idiomas.
	No programa deve ser escolhido qual o idioma da busca (Português=>Inglês ou Inglês=>Português), assim como solicitar a palavra para ser traduzida.*/
	
	public static void ordenar_por(String matriz[][]){//selection sort
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
	public static void ordenar_ing(String matriz[][]) {//selection sort
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
	}
	public static String traduzir_por(String matriz[][],String palavra) {//busca binária em vetor ordenado
		int ini = 0;
		int fim = matriz.length -1;
		while(ini <= fim) {
			int meio = (fim+ini)/2;
			Collator cot = Collator.getInstance(new Locale("pt", "BR"));
			cot.setStrength (Collator.PRIMARY);
			
			int aux = cot.compare(palavra,matriz[meio][0]);
			if(aux < 0) {
				fim = meio - 1;
			}else if(aux > 0) {
				ini = meio + 1;
			}else {
				String s = " ";
				for (int j = 0; j < 2; j++) {
					s += matriz[meio][j];
					if(j == 0) {
						s += " = ";
					}
				}
				return s;
			}

		}
		String e = "Palavra não encontrada!"; 
		return e;
	}
	public static String traduzir_ing(String matriz[][],String palavra) {//busca binária em vetor ordenado
		/*for (int i = 0; i < matriz.length; i++) {//trocar posição na matriz
			String arm = matriz[i][0];
			matriz[i][0] = matriz[i][1];
			matriz[i][1] = arm;
			
		}*/
		int ini = 0;
		int fim = matriz.length -1;
		while(ini <= fim) {
			int meio = (fim+ini)/2;
			int aux = palavra.compareToIgnoreCase(matriz[meio][1]);
			if(aux < 0) {
				fim = meio - 1;
			}else if(aux > 0) {
				ini = meio + 1;
			}else {
				String s = " ";
				s += matriz[meio][1];
				s += " = ";
				s += matriz[meio][0];
				return s;
			}

		}
		String e = "Palavra não encontrada!"; 
		return e;
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
		
		Scanner e = new Scanner(System.in);
        int op = 0;
        String palavra; 
        do {
            System.out.println("---- Menu ---");
            System.out.println("[1] Portugês");
            System.out.println("[2] Inglês");
            System.out.println("[0] FIM");
            System.out.println("-------------");
            op = e.nextInt(); 
            e.nextLine();
            if (op == 1) {
            	ordenar_por(dic);
                System.out.print("Digite a palavra em Português: ");
                palavra = e.nextLine();
                System.out.println("--- Tradução ---");
                System.out.println(traduzir_por(dic, palavra));
                System.out.println();
            }
            if (op == 2) {
            	ordenar_ing(dic);
                System.out.print("Digite a palavra em Inglês: ");
                palavra = e.nextLine();
                System.out.println("--- Tradução ---");
                System.out.println(traduzir_ing(dic,palavra));
                System.out.println();
            }
        } while (op != 0);
	}

}
