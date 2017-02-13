package aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cliente.IGContatos.Contato;

public class GerenciaContatos {

		Map<String, ContatoPlus> MapContatos;
		Map<String, ContatoPlus> favoritos;
		
		public GerenciaContatos() {
			MapContatos = new TreeMap <String, ContatoPlus>();
			favoritos = new TreeMap <String, ContatoPlus>();
			
		}

	    boolean createContact(Contato contato){
	    	if(contato == null) return false; // Nulo ? 
	    	
	    	if(contato.id.isEmpty() || contato.id.equals("")) return false; // ID vazio ? 
	    	
	    	if(contato.email.isEmpty() || contato.email.equals("")) return false; // E-Mail vazio ? 
	    	
	    	if(!isValid(contato)) return false; // Email tem "@" ?
	    	
	    	if(MapContatos.containsKey(contato.id)) return false; //ID unico
	    	
	    	MapContatos.put(contato.id, new ContatoPlus(contato)); // Addd no Map
	    	return true;
	    }
	    
	  
   
	    List<Contato> getAllContacts(){
	    	return new ArrayList<Contato>(MapContatos.values());
	    }
	    
	    boolean updateContact(Contato contato){
	    	if(contato == null) return false; // Null ?
	    	
	    	if(MapContatos.containsKey(contato.id)){
	    	MapContatos.get(contato.id).setEmail(contato.email); // Atualizando o Email
	    	return true;
	    	}
	    	return false;
	    }
	    
	    Contato getContact(String idContato){
	    	return MapContatos.get(idContato);
	    }
	    
	    private boolean isValid(Contato c){
	    	
	    	if(c.email.contains("@")){
	    		return true;
	    	}
			return false;
		}
	   
	    boolean favoriteContact(String idContato){
	    	
	    	if(MapContatos.containsKey(idContato)){
	    		favoritos.put(idContato, MapContatos.get(idContato));
	    		return true;
	    	}
	    	return false;
	    }
	    
	    boolean unfavoriteContact(String idContato){
	    	
	    	if(favoritos.containsKey(idContato)){
	    		favoritos.remove(idContato);
	    		return true;
	    	}
	    	return false;
	    }
	    
	    boolean isFavorited(String idContato){
	    	
	    	if(favoritos.containsKey(idContato)){
	    		return true;
	    	}
	    	return false;
	    }
	    
	    List<Contato> getFavorited(){
	    	return new ArrayList<Contato>(favoritos.values());
	    }
	    
	    void checkingDeleting(String id){
	    	for(ContatoPlus contato : MapContatos.values()){
	    		if(contato.MeusCirculos.containsKey(id)){
	    			contato.MeusCirculos.remove(id);
	    		}
	    	}
	    }
	
}
