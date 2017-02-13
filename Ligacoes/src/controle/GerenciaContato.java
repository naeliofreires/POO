package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cliente.Contato;

public class GerenciaContato {

	protected Map<String,ContatoPlus> mapa;
	protected List<String> favoritos ;
	
	public GerenciaContato() {
		mapa = new TreeMap <String, ContatoPlus>();
		favoritos = new ArrayList<>();
	}

	public boolean addContato(Contato contato) {
		
		if(contato == null || mapa.containsKey(contato.getNome())){
			return false;
		}
		
		mapa.put(contato.getNome(), new ContatoPlus(contato));
		
		return true;
	
	}

	
	public boolean rmContato(String nome) {
		
//		Verificando requisitos 
		if(!verificarNome(nome)){
			return false;
		}
//		Removendo dos Fav
		if(favoritos.contains(nome)){
			favoritos.remove(nome);
		}
//		Removendo do Map
		if(mapa.containsKey(nome)){
			mapa.remove(nome);
			return true;
		}
		
		return false;
	}

	
	public Contato getContato(String nome) {
		
		if(verificarNome(nome)){
			if(mapa.containsKey(nome)){
				return mapa.get(nome);
			}
		}
		return null;
	}

	
	public List<ContatoPlus> getListContatos() {
		return new ArrayList<ContatoPlus>(mapa.values());
	}
	
	public boolean atualizarContato(String nomeAntigo, ContatoPlus contato) {
		
		if(!verificarNome(nomeAntigo) || contato == null || !mapa.containsKey(nomeAntigo)){
			return false;
		}
		
		if(mapa.containsKey(nomeAntigo) && !mapa.containsKey(contato.getNome())){
			if(favoritos.contains(nomeAntigo)){
				favoritos.remove(nomeAntigo);
				favoritos.add(contato.getNome());
			}
			rmContato(nomeAntigo);
			mapa.put(contato.getNome(), contato);
			return true;
		}
		
		return false;
	}

	
	public boolean addTelContato(String nome, String newTelefone) {
		
		if(!verificarNome(nome)) return false;
		if(!verificarTelefone(newTelefone)) return false;
		
		if(mapa.containsKey(nome)){
			
			if(mapa.get(nome).getTelefones().contains(newTelefone)){
				return false; // Verifica se ja tem o contato
			}
			mapa.get(nome).getTelefones().add(newTelefone);
			
			return true;
		}
		
		return false;
	}

	
	public boolean rmTelContato(String nome, String telefone) {
		
		if(!verificarNome(nome)) return false;
		if(!verificarTelefone(telefone)) return false;
		
		if(mapa.containsKey(nome)){
			
			if(!mapa.get(nome).getTelefones().contains(telefone)){
				return false; //Verifica se contem o telefone
			}
			
			mapa.get(nome).getTelefones().remove(telefone); // removendo
		
			return true;
		}
		return false;
	}
	
	private boolean verificarNome(String nome){		
		
		if(nome.trim().equals("") || nome == null ){
			return false;
		}
		return true;
	}
	
	private boolean verificarTelefone(String telefone){

		if(telefone.trim().equals("") || telefone == null){
			return false;
		}
		
		 for (char letra : telefone.toCharArray())  
	            if(letra < '0' || letra > '9')  
	                return false;  
	       
		 return true;  
	}
	

}
