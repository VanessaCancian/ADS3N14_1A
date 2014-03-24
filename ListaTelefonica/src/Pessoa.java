
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
 
/**
 * faz a leitura e a escrita em arquivos TXT com Java
 * 
*/
public class Pessoa {
 
   private String Arquivo; 
 
   
    public Pessoa(String nomeArquivo) {
        this.Arquivo = nomeArquivo;
    }
 
    // metodos 
    public void insereDados(String registro) {
        File arquivoTxt = null;
        try {
            arquivoTxt = new File(this.Arquivo);
            FileWriter fwArquivo = null; // usado para gravacao de arquivos
 
            /* Verifica se o arquivo existe
             Se existir, ele abre par adicionar dados
             se nao existir, ele cria o arquivo */
            
            if (arquivoTxt.exists() == true) {
                fwArquivo = new FileWriter(arquivoTxt, true);
            } else {
                fwArquivo = new FileWriter(arquivoTxt);
            }
 
            BufferedWriter bw = new BufferedWriter(fwArquivo); 
 
            //escreve o registro no arquivo e pula uma linha com o \n
            bw.write(registro + "\n");
 
            System.out.println("Registro adicionado!");
 
            //fecha o arquivo
            bw.close();
            fwArquivo.close();
 
        } catch (Exception e) { // mensagem de erro caso o arquivo nao seja inserido
            System.err.println("Erro ao inserir linhas no arquivo: " + arquivoTxt);
        }
    }
 
    public void listaDados() { 
        Scanner lendoArquivo = null;
        File arquivo = null;
        try {
            // abre o arquivo para leitura
            // se o arquivo nao existir dispara a excecao
            arquivo = new File(this.Arquivo);
            lendoArquivo = new Scanner(arquivo);
 
            // le o arquivo linha por linha até chegar ao fim
            while (lendoArquivo.hasNextLine()) {
                this.criandoLinha(lendoArquivo.nextLine());
            }
 
 
        } catch (FileNotFoundException e) { /* trata quando o arquivo nao existe ou 
        									esta com nome ou caminho diferente */
            System.err.println("Erro: arquivo nao existe. " + arquivo);
        } finally {
            // fecha o scanner
            try {
                lendoArquivo.close();
            } catch (Exception e) {
            }
        }
    }
 
    private void criandoLinha(String linha) {
    		// cria uma linha com a insercao dos dados
    		// nome:telefone
        if (linha != null) {
            // separa os campos atraves do delimitador ':'
            String[] campos = linha.split(":");
 
            System.out.print("Nome: " + campos[0].trim());
            System.out.println("\tFone: " + campos[1].trim());
            System.out.println("--------------------------------------\n");
        }
    }
 
   public void menu() {
        // passando para o objeto da classe Scanner o dispositivo de entrada padrão
        // que é o teclado
        Scanner teclado = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println("1 - Inserir Contato");
            System.out.println("2 - Lista os contatos");
            System.out.println("3 - Sair");
            System.out.print("Entre com uma opcao: ");
            op = teclado.nextInt();
 
            switch (op) {
                case 1:
                    teclado.nextLine();
                    String nome;
                    String telefone;
                    System.out.println("Entre com os dados:");
                    System.out.print("Nome: ");
                    nome = teclado.nextLine();
                    System.out.print("Fone: ");
                    telefone = teclado.nextLine();
                    this.insereDados(nome + ":" + telefone);
                    break;
                case 2:
                    this.listaDados();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
 
        } while (op != 3);
    }
 
  }