public class No {
	No pai;
	String codigo;
	Pessoa valor;
	No filhoEsquerda;
	No filhoDireita;
	
	public No()
	{
		valor = new Pessoa();
	}

	public void mostraNo() {
		System.out.print("{");
		System.out.print(codigo);
		System.out.print(", ");
		System.out.print(valor.getNome());
		System.out.print(", ");
		System.out.print(valor.getFone());
		System.out.print("} ");
		System.out.println("");
	}
}
