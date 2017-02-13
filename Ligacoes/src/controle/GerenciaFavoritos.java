package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cliente.Contato;

public class GerenciaFavoritos {
	
	GerenciaContato GC ;
	//	Lembre que no GerenciaContato
	//	Ele já possui seu Map e Lis<Favoritos>
	//	Cria um GerenciaContato e igual a um por parametro 
	//	para fazer referencia, e ter acesso a ele por endereco
	
	public GerenciaFavoritos(GerenciaContato GC) {
		this.GC = GC;
	}

	public boolean favoritar(String nome) {
		
		if(!verificarNome(nome)) return false;
		if(GC.favoritos.contains(nome)) return false;
		if(GC.mapa.containsKey(nome)){
			GC.favoritos.add(nome);
			return true;
		}
		return false;
	}

	
	public boolean desfavoritar(String nome) {
		
		if(!verificarNome(nome)) return false; // Requisitos nome
		if(!GC.favoritos.contains(nome)) return false; //Pra não favoritar 2x
		
		if(GC.mapa.containsKey(nome)){ //Não favoritar quem não existe
			GC.favoritos.remove(nome);
			return true;
		}
		return false;
	}
	
	
	public List<Contato> getFavoritos() {
		
		List<Contato> FavContatos = new ArrayList<Contato>();
		
		Collections.sort(GC.favoritos);
		
		for(String c : GC.favoritos){ //Para cada c em favoritos
			if(GC.mapa.containsKey(c)) // Se contem no Mapa
				FavContatos.add(GC.mapa.get(c)); // add 
		}	
		return FavContatos;
	}
	
	private boolean verificarNome(String nome){		
		
		if(nome.trim().equals("") || nome == null ){
			return false;
		}
		return true;
	}
}
