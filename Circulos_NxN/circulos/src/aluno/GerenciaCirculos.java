package aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cliente.IGContatos.Circulo;

public class GerenciaCirculos {
	
	Map<String, CirculoPlus> MapCirculos;
	public GerenciaCirculos() {
		MapCirculos = new TreeMap<String, CirculoPlus>();
	}
	 
    boolean createCircle(Circulo circulo){
    	
    	if(circulo == null) return false;
    	
    	if(MapCirculos.containsKey(circulo.id)) return false;
    	
    	MapCirculos.put(circulo.id, new CirculoPlus(circulo));
    	
    	return true;
    }
    
    boolean updateCircle(Circulo circulo){
    	if(circulo == null) return false;
    	if(MapCirculos.containsKey(circulo.id)){
    		removeCircle(circulo.id);
    		createCircle(circulo);
    		return true;
    	}
    	return false;
    }

    boolean removeCircle(String idCirculo){
    	if(MapCirculos.containsKey(idCirculo)){
    		MapCirculos.remove(idCirculo);
    		return true;
    	}
    	return false;
    }
    
    Circulo getCircle(String idCirculo){
    	return MapCirculos.get(idCirculo);
    }
    
    List<Circulo> getAllCircles(){
    	return new ArrayList<Circulo>(MapCirculos.values());
    } 
    
    void checkingDeleting(String id){
    	for(CirculoPlus a : MapCirculos.values()){
    		if(a.MeusContatos.containsKey(id)){//Se circulo contem contato
    			a.MeusContatos.remove(id); // Remove contato do circulo
    		}
    	}
    }

}
