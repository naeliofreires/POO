package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import cliente.Contato;

public class GerenciaLigacoes {

	ArrayList<ContatoPlus> allLigacoes;
	GerenciaContato GC;
	
	public GerenciaLigacoes(GerenciaContato gc) {
		GC = gc;
		allLigacoes = new ArrayList<ContatoPlus>();
	}

	//		Ordena os contatos pela quantidade de ligações
	public List<Contato> getMaisLigados(int qtd) {
		
		List<ContatoPlus> list = new ArrayList<ContatoPlus>(GC.getListContatos());
		
		Collections.sort(list);
		
//		Se a quantidade for mais igual ao tamanho da lista. 
		if(qtd >= list.size()){
			return new ArrayList<Contato>(list);
		}
		return new ArrayList<Contato>(list.subList(0, qtd));
	}

	public void ligar(String telefone) {
//		Tenho que achar o telefone referente ao contato, caso não ache, mesmo assim ainda vai pro historico
		for(ContatoPlus c : GC.mapa.values()){
			if(c.getTelefones().contains(telefone)){
				allLigacoes.add(c);
				c.ligou_numero(); // Incrementa ligacoes
				return;	
			}
		}		
		allLigacoes.add(new ContatoPlus(telefone,telefone));
	}

	public List<Contato> getHistorico(int qtd) {
			
		return null;
	}
	
	public void limparHistorico() {
		allLigacoes.clear();
	}

}
