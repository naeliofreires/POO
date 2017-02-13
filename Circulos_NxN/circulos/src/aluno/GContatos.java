package aluno;

import java.util.List;

import cliente.IGContatos;

public class GContatos implements IGContatos {

//	NXN
//	Um circulo pode ter varios contatos
//	Um contato pode ter varios circulos
	GerenciaCirculos Circ;
	GerenciaContatos Cont;
	GerenciaRelacoes GRelac;
	
	public GContatos() {
		Circ = new GerenciaCirculos();
		Cont = new GerenciaContatos();
		GRelac = new GerenciaRelacoes(Circ, Cont);
	}

	@Override
	public boolean createContact(Contato contato) {
		return (Cont.createContact(contato));
	}

	@Override
	public List<Contato> getAllContacts() {
		return Cont.getAllContacts();
	}

	@Override
	public boolean updateContact(Contato contato) {
		return (Cont.updateContact(contato));
	}

	@Override
	  public boolean removeContact(String idContato) {
    	
    	if(Cont.MapContatos.containsKey(idContato)){
    		unfavoriteContact(idContato);
    		Cont.MapContatos.remove(idContato);
    		Circ.checkingDeleting(idContato);
    		return true;
    	}
    	
		return false;
	   }

	@Override
	public Contato getContact(String idContato) {
		return (Cont.getContact(idContato));
	}

	@Override
	public boolean createCircle(Circulo circulo) {
		return (Circ.createCircle(circulo));
	}

	@Override
	public boolean updateCircle(Circulo circulo) {
		return (Circ.updateCircle(circulo));
	}

	@Override
	public Circulo getCircle(String idCirculo) {
		return Circ.getCircle(idCirculo);
	}

	@Override
	public List<Circulo> getAllCircles() {
		return Circ.getAllCircles();
	}

	@Override
	public boolean removeCircle(String idCirculo){
    	if(Circ.MapCirculos.containsKey(idCirculo)){
    		Circ.MapCirculos.remove(idCirculo);
    		Cont.checkingDeleting(idCirculo);
    		return true;
    	}
    	return false;
    }

	@Override
	public boolean tie(String idContato, String idCirculo) {
		return (GRelac.tie(idContato, idCirculo));
	}

	@Override
	public boolean untie(String idContato, String idCirculo) {
		return (GRelac.untie(idContato, idCirculo));
	}

	@Override
	public List<Contato> getContacts(String idCirculo) {
		return (GRelac.getContacts(idCirculo));
	}

	@Override
	public List<Circulo> getCircles(String idContato) {
		return (GRelac.getCircles(idContato));
	}

	@Override
	public boolean favoriteContact(String idContato) {
		return (Cont.favoriteContact(idContato));
	}

	@Override
	public boolean unfavoriteContact(String idContato) {
		return (Cont.unfavoriteContact(idContato));
	}

	@Override
	public boolean isFavorited(String idContato) {
		return (Cont.isFavorited(idContato));
	}
	@Override
	public List<Contato> getFavorited() {
		return (Cont.getFavorited());
	}

}
