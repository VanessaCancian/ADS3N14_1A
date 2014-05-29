import java.util.Scanner;


public class Programa {
	Arvore arv;
	No noAtual;
	
	public Programa()
	{
		arv = Arquivo.carregar();
		noAtual = arv.raiz;
	}
	
	public void inicio()
	{
		principal();
	}
	
	public void principal()
	{
		noAtual.mostraNo();
		
		lnMsg("O que deseja fazer?");
		lnMsg("1 - Adicionar contato");
		lnMsg("2 - Remover contato");
		lnMsg("3 - Procurar contato");
		lnMsg("4 - Travessia prefixa");
		lnMsg("5 - Travessia infixa");
		lnMsg("6 - Travessia posfixa");
		lnMsg("7 - Busca profundidade");
		lnMsg("8 - Busca largura");
		lnMsg("9 - Sair");
		
		int num = (new Scanner(System.in)).nextInt();
		
		switch(num)
		{
		case 1:
			adicionar();
			break;
		case 2:
			remover();
			break;
		case 3:
			procurar();
			break;
		case 4:
			arv.travessia(1);
			principal();
			break;
		case 5:
			arv.travessia(2);
			principal();
			break;
		case 6:
			arv.travessia(3);
			principal();
			break;
		case 7:
			arv.travessia(4);
			principal();
			break;
		case 8:
			arv.travessia(5);
			principal();
			break;
		case 9:
			sair();
			break;
		default:
			lnMsg("Digite uma opção válida");
			principal();
			break;
		}
	}
	
	private void adicionar()
	{
		No novo = new No();
		
		lnMsg("Digite o nome: ");
		String nome = (new Scanner(System.in).nextLine());
		novo.valor.setNome(nome);
		lnMsg("Digite o telefone: ");
		novo.valor.setFone((new Scanner(System.in).nextLine()));
		novo.codigo = nome;
		
		arv.insere(novo, true);
		lnMsg("Inserido!");
		lnMsg("Total de contatos: " + arv.numNos);
		
		principal();
	}
	
	private void remover()
	{
		lnMsg("Digite o nome: ");
		String nome = (new Scanner(System.in)).nextLine();
		
		arv.delete(nome);
		lnMsg("Removido!");
		lnMsg("Total de contatos: " + arv.numNos);
		
		principal();
	}
	
	private void procurar()
	{
		lnMsg("Digite o nome: ");
		String nome = (new Scanner(System.in)).nextLine();
		
		No pesq = arv.pesquisa(nome);
		
		if (pesq == null)
		{
			lnMsg("Nada encontrado!");
		}
		else 
		{
			noAtual = pesq;
		}
		
		principal();
	}
	
	private void lnMsg(String msg)
	{
		System.out.println(msg);
	}
	
	private void msg(String msg)
	{
		System.out.print(msg);
	}
	
	private void sair()
	{
		Arquivo.salvar(arv);
		System.exit(0);
	}
}
