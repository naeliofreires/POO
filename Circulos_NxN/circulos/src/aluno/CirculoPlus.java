package aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cliente.IGContatos.Circulo;

public class CirculoPlus extends Circulo{
	
	Map<String,ContatoPlus> MeusContatos;
	
	public CirculoPlus(String id, int limite) {
		 super(id, limite);
		 MeusContatos = new TreeMap<String,ContatoPlus>();
	}
	
	public CirculoPlus(Circulo circulo) {
		super(circulo.id, circulo.limite);
		MeusContatos = new TreeMap<String,ContatoPlus>();
	}
	
	public int getLimite(){
		return this.limite;
	}
	
	public String getID(){
		return this.id;
	}
	
	public void setLimite(int newLimite){
		this.limite = newLimite;
	}
	
	public void serID(String id){
		this.id = id;
	}
	
	public void addContatoNoCirculo(ContatoPlus contato){
		this.MeusContatos.put(contato.getID(),contato);
	}
	
	public List<ContatoPlus> allContatos(){
		return new ArrayList<ContatoPlus>(this.MeusContatos.values());
	}
	
	public boolean deletingContact(String idContato){
		if(this.MeusContatos.containsKey(idContato)){
			this.MeusContatos.remove(idContato);
			return true;
		}
		return false;
	}
}