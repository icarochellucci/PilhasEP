import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class PilhaIngenua {

    protected final int MAX = 1000000;
    protected String [] pilha;

    PilhaIngenua (){ pilha = new String [MAX] ; }

    void add(String newElement) {
        int i;
        for(i = 0; pilha[i] != null; i++);
        pilha[i] = newElement;
    }
    String remove () {
        int i;
        for(i = 0; pilha[i] != null; i++);
        String tmp = pilha[i-1];
        pilha[i-1] = null;
        return tmp;
    }
	
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner arquivos = new Scanner(System.in);
        // Inserir o local de entrada de arquivos
        System.out.println("Especifique o caminho do arquivo de entrada: ");
        // EXEMPLO===> "C:\\entradas\\tarefas1000.txt"
        String entradaArquivos = arquivos.nextLine();
        // Inserir o local de saída de arquivos
        System.out.println("Especifique o caminho do arquivo de saída e seu título a ser criado: ");
        // EXEMPLO==> "C:\\saidas\\PIsaidas\\PIsaidas1000.txt"
        String saidaArquivos = arquivos.nextLine();
    	long start = System.currentTimeMillis(); // Início do cronômetro  
        File entradaDados = new File (entradaArquivos);        
        arquivos.close();
	        try{
	        	Scanner dados = new Scanner(entradaDados);
	            FileWriter fileWriter = new FileWriter(saidaArquivos);
	            PrintWriter printWriter = new PrintWriter(fileWriter);
                PilhaIngenua pilhaIngenua = new PilhaIngenua();
	            while(dados.hasNext()){
	                String leitura = dados.nextLine();
	                if (leitura.equals("")){
	                    String proximo = pilhaIngenua.remove();                   
	                    printWriter.print(proximo);
	                    printWriter.print("\n");
	                    printWriter.flush();
	                }else{pilhaIngenua.add(leitura);}
	            }
	            printWriter.close();
	            dados.close();
	        }catch (IOException ex){
	        	System.out.println("Erro ao escrever arquivo: " + ex.getMessage());
	        }
	        long end = System.currentTimeMillis();// fim do cronometro
	        double total = (double) (end - start)/1000;
	        System.out.println("Começo do programa = "+start);
	        System.out.println("Fim do programa = "+end);
	        System.out.println("Tempo total = "+total+" segundos");
	    }
	}