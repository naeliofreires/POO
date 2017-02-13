package cliente;

import java.util.ArrayList;
import java.util.List;

public class Contato {
	
	protected List<String> telefones; // Varios telefones
	protected String nome; //Apenas um nome
	
	public Contato(String nome, String ... telefones){
		
		this.nome = nome; // add nome
		
		this.telefones = new ArrayList<String>();
		for(String s : telefones)
			this.telefones.add(s);
	}
	
	public String getNome(){
		return nome;
	}
	
	public List<String> getTelefones(){
		return telefones;
	}
}
