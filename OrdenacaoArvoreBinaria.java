package Exer_02;

import java.text.Collator;
import java.util.Locale;

public class Exer02 {
	
	/*Utilizar uma �rvore bin�ria de busca para fazer a ordena��o da estrutura com duas palavras (String),
	tipo um dicion�rio com a palavra e a tradu��o (Portugu�s/Ingl�s). 
	Enviar os dados para a �rvore e depois gerar uma estrutura de volta com os dados ordenados. 
	Considere a classe NoArvore abaixo para armazenar as palavras (portugu�s/Ingl�s) na �rvore. 
	Usar a linguagem JAVA para essa tarefa. Colocar no teste a op��o de ordenar por qualquer uma das l�nguas.*/
	
	public static class NoArvore {
		public String por,ing;
		public NoArvore left,right;
		
		public NoArvore(String p,String i) {
			por = p;
			ing = i;
			left = null;
			right = null;
		}
		public NoArvore() {
			left = null;
			right = null;
		}
	}
	public static NoArvore inserirPor(NoArvore no, String p,String i) {
			if (no == null){
				no = new NoArvore(p,i);				                 
				return no;                    	
			} else {
				Collator cot = Collator.getInstance(new Locale("pt", "BR"));
				cot.setStrength (Collator.PRIMARY);
				int resp = cot.compare(p,no.por);
				if(resp == 0) {
					System.out.println("Erro.\nPalavra j� existe na �rvore.");
				}else if (resp > 0){
					no.right = inserirPor(no.right,p,i);
				}else {
					no.left = inserirPor(no.left,p,i);
				}
				return no;
			}
	}
	public static NoArvore inserirIng(NoArvore no, String p,String i) {
		if (no == null){
			no = new NoArvore(p,i);				                 
			return no;                    	
		} else { 
			int resp = i.compareToIgnoreCase(no.ing);
			if(resp == 0) {
				System.out.println("Erro.\nPalavra j� existe na �rvore.");
			}else if (resp > 0){
				no.right = inserirIng(no.right,p,i);
			}else {
				no.left = inserirIng(no.left,p,i);
			}
			return no;
		}
	}
	public static void ordenar(NoArvore no,String opcao){//ordem simetrica (LDR)
		if(opcao.equalsIgnoreCase("por")) {
			if(no != null) {
				ordenar(no.left,opcao);
				System.out.println(" "+ no.por +" - "+ no.ing);
				ordenar(no.right,opcao);
			}
		}else if(opcao.equalsIgnoreCase("ing")){
			if(no != null) {
				ordenar(no.left,opcao);
				System.out.println(" "+ no.ing +" - "+ no.por);
				ordenar(no.right,opcao);
			}
		}else {
			System.out.println("Erro.\nOp��o Inv�lida.");
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
		NoArvore a = null;
		
		System.out.println("---- Antes da ordena��o ----");
		for (int i = 0; i < dic.length; i++) {
			for (int j = 0; j < dic[i].length; j++) {
				System.out.print(" "+ dic[i][j] +" ");
				if(j == 0) {
					System.out.print("-");
				}
			}
			System.out.println();
		}
		
		//insert
		for (int i = 0; i < dic.length; i++) {
			//a = inserirPor(a,dic[i][0],dic[i][1]);
			a = inserirIng(a,dic[i][0],dic[i][1]);
		}
		
		System.out.println("\n---- Depois da ordena��o ----");
		//ordenar(a,"por");
		ordenar(a,"ing");
	}

}
