package controle;

import java.util.ArrayList;
import java.util.List;

import cliente.Contato;
import cliente.ITelefone;

public class Telefone implements ITelefone {

	
	GerenciaContato GC ;
	GerenciaFavoritos GF ;
	GerenciaLigacoes GL ;
	
	protected List<String> registro;
	
	public Telefone(){
		GC = new GerenciaContato();
		GF = new GerenciaFavoritos(GC);
		GL = new GerenciaLigacoes(GC);
	}
	
	@Override
	public boolean addContato(Contato contato) {
	
		if(GC.addContato(contato)) return true;
		
		return false;
	}

	@Override
	public boolean rmContato(String nome) {
		
		if(GC.rmContato(nome)) return true;
		
		return false;
	}

	@Override
	public Contato getContato(String nome) {
		return GC.getContato(nome);		
	}

	@Override
	public List<Contato> getListContatos() {
		return new ArrayList<Contato>(GC.getListContatos());
	}
 
	@Override
	public boolean atualizarContato(String nomeAntigo, Contato contato) {
		
		if(GC.atualizarContato(nomeAntigo, new ContatoPlus(contato))) return true;
		
		return false;
	}

	@Override
	public boolean addTelContato(String nome, String newTelefone) {
		
		if(GC.addTelContato(nome, newTelefone)) return true;
		
		return false;
	}

	@Override
	public boolean rmTelContato(String nome, String telefone) {
		
		if(GC.rmTelContato(nome, telefone)) return true;
		
		return false;
	}

	@Override
	public boolean favoritar(String nome) {
		
		if(GF.favoritar(nome)) return true;
		
		return false;
	}

	@Override
	public boolean desfavoritar(String nome) {
		
		if(GF.desfavoritar(nome)) return true;
		
		return false;
	}

	@Override
	public List<Contato> getFavoritos() {
		return GF.getFavoritos();
	}

	@Override
	public List<Contato> getMaisLigados(int qtd) {
		
		return new ArrayList<Contato>(GL.getMaisLigados(qtd));
	}

	@Override
	public void ligar(String telefone) {
		GL.ligar(telefone);
	}

	@Override
	public List<Contato> getHistorico(int qtd) {
		return new ArrayList<Contato>(GL.getHistorico(qtd));
	}

	@Override
	public void limparHistorico() {
		GL.limparHistorico();
	}
		
}//Final





