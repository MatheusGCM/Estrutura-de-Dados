package Exer_04;

public class Exer04 {
	
	/*Implementar em JAVA uma árvore binária de busca para inserir e procurar palavras (português/Inglês) nessa árvore na forma de um dicionário. 
	A busca deve procurar por uma palavra na árvore de palavras (português/Inglês). Usar as mesmas palavras da questão 4. 
	No programa deve ser feita a tradução de Inglês=>Português. Solicitar a palavra para ser traduzida. 
	Usar a estrutura de matriz de palavras para entrar com os dados na árvore.
	Considere a classe NoArvore abaixo para armazenar as palavras (português/Inglês) na árvore.*/
	
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
	
	public static NoArvore inserirIng(NoArvore no, String p,String i) {
		if (no == null){
			no = new NoArvore(p,i);				                 
			return no;                    	
		} else { 
			int resp = i.compareToIgnoreCase(no.ing);
			if(resp == 0) {
				System.out.println("Erro.\nPalavra já existe na árvore.");
			}else if (resp > 0){
				no.right = inserirIng(no.right,p,i);
			}else {
				no.left = inserirIng(no.left,p,i);
			}
			return no;
		}
	}
	public static NoArvore procurarPalavraIng(NoArvore no,String palavra) {
		if (no == null) {
            return no;
        } else {
    		int resp = palavra.compareToIgnoreCase(no.ing);
            if (resp == 0) {
                return no;
            } else {
            	if (resp > 0) {
                    return procurarPalavraIng(no.right, palavra);
                } else {
                    return procurarPalavraIng(no.left, palavra);
                }
            }
        }
	}
	public static NoArvore traduzir(NoArvore no,String palavra){
		NoArvore resp = procurarPalavraIng(no,palavra);
		return resp;
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
		NoArvore a = null,resp;
		
		for (int i = 0; i < dic.length; i++) {
			a = inserirIng(a,dic[i][0],dic[i][1]);
		}
		
		
		resp = traduzir(a,"sol");
		if(resp != null) {
			System.out.println("--- TRADUÇÃO ---");
			System.out.println(" "+ resp.ing +" = "+ resp.por);
		}else {
			System.out.println("Tradução não encontrada!");
		}
		
	}
}
