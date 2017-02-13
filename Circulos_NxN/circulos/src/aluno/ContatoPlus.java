package aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import cliente.IGContatos.Circulo;
import cliente.IGContatos.Contato;

public class ContatoPlus extends Contato {

	Map<String, CirculoPlus> MeusCirculos;
	
	public ContatoPlus(String id, String email) {
		super(id, email);
		MeusCirculos = new TreeMap<String, CirculoPlus>();
	}
	
	public ContatoPlus(Contato c) {
		super(c.id, c.email);
		MeusCirculos = new TreeMap<String, CirculoPlus>();	
	}
	
	public String getID(){
		return this.id; 
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setID(String id){
		this.id = id;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void addCirculoNoContato(CirculoPlus circulo){
		MeusCirculos.put(circulo.getID(),circulo);
	}
	
	public List<Circulo> allCirculos(){
		return new ArrayList<Circulo>(MeusCirculos.values());
	}

	
}
