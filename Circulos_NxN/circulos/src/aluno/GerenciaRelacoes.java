package aluno;

import java.util.ArrayList;
import java.util.List;

import cliente.IGContatos.Circulo;
import cliente.IGContatos.Contato;

public class GerenciaRelacoes {

	GerenciaCirculos GCirc;
	GerenciaContatos GCont;
	
	 public GerenciaRelacoes(GerenciaCirculos GCirc , GerenciaContatos GCont ) {
		 this.GCirc = GCirc;
		 this.GCont = GCont;
	}

    boolean tie(String idContato, String idCirculo){
    	
    	if(idContato == null || idCirculo == null)
    		return false;
    	
    	if(!GCont.MapContatos.containsKey(idContato))
    		return false;
    	
    	if(!GCirc.MapCirculos.containsKey(idCirculo))
    		return false;

    	if(GCirc.MapCirculos.get(idCirculo).getLimite() >= GCirc.MapCirculos.get(idCirculo).MeusContatos.size()){
    		//add contato no circulo
    		GCirc.MapCirculos.get(idCirculo).addContatoNoCirculo(GCont.MapContatos.get(idContato));
    		//add circulo no contato
    		GCont.MapContatos.get(idContato).addCirculoNoContato(GCirc.MapCirculos.get(idCirculo));
    		
    		return true;
    	}
    	
    	return false;
    	
    }
    
    boolean untie(String idContato, String idCirculo){
    	
    	if(idContato == null || idCirculo == null)
    		return false;
    	
    	if(!GCont.MapContatos.containsKey(idContato))
    		return false;
    	
    	if(!GCirc.MapCirculos.containsKey(idCirculo))
    		return false;
    	
    	if(GCirc.MapCirculos.containsKey(idCirculo)){
    		if(GCirc.MapCirculos.get(idCirculo).MeusContatos.containsKey(idContato)){
    			GCirc.MapCirculos.get(idCirculo).MeusContatos.remove(idContato);
    			GCont.MapContatos.get(idContato).MeusCirculos.remove(idCirculo);
    			return true;
    		}
    	}
    	return false;
    }

    //retorna a lista de contatos ordenados por nome
    List<Contato> getContacts(String idCirculo){
    	return new ArrayList<Contato>(GCirc.MapCirculos.get(idCirculo).allContatos());
    }
    
    //retorna a lista de circulos ordenados por nome
    List<Circulo> getCircles(String idContato){
    	return new ArrayList<Circulo>(GCont.MapContatos.get(idContato).allCirculos());   			
    }
}
