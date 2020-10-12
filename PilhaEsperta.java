import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PilhaEsperta {
    public static void main (String [] args){
        Scanner arquivos = new Scanner(System.in);
        // Inserir o local de entrada de arquivos
        System.out.println("Especifique o caminho do arquivo de entrada: ");
        // EXEMPLO===> "C:\\entradas\\tarefas1000.txt"
        String entradaArquivos = arquivos.nextLine();
        // Inserir o local de saída de arquivos
        System.out.println("Especifique o caminho do arquivo de saída e seu título a ser criado: ");
        // EXEMPLO==> "C:\\PEsaidas\\PEsaidas1000.txt"
        String saidaArquivos = arquivos.nextLine();
    	long start = System.currentTimeMillis(); // Início do cronômetro  
        File entradaDados = new File (entradaArquivos);        
        Stack <String> stack = new NodeStack <String> ();
        arquivos.close();
        try{
            Scanner dados = new Scanner(entradaDados);
            FileWriter fileWriter = new FileWriter(saidaArquivos);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            while(dados.hasNext()){
                String linha = dados.nextLine();
                if (linha.equals("")){
                    String processado = stack.pop();                   
                    printWriter.print(processado);
                    printWriter.print("\n");
                    printWriter.flush();
                }else{stack.push(linha);}
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