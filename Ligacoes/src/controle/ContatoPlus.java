package controle;

import cliente.Contato;

public class ContatoPlus extends Contato implements Comparable<ContatoPlus>{

//	Número de ligações
	private int ligacoes = 0;
	
	
	
	public ContatoPlus(String nome, String ... telefones) {//Construtor
		super(nome, telefones);
	}
		
	public ContatoPlus(Contato contato) {
		super(contato.getNome(), contato.getTelefones().toArray(new String[contato.getTelefones().size()]));
	}

	public int getLigacoes() {
//		Retorna o valor atual da 'ligacoes'
		return ligacoes; 
	}

	public void ligou_numero(){
		this.ligacoes = getLigacoes() + 1;
	}
	
	@Override
	public int compareTo(ContatoPlus c) {
		// do maior para o menor
//					4		-		5		= -1
//					3		-		2		=  1
		return c.getLigacoes()-this.getLigacoes();
	}
}
