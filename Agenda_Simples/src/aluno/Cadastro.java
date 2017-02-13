package aluno;

import java.util.ArrayList;
import java.util.List;

import cliente.ICadastro;
import cliente.IContato;

public class Cadastro implements ICadastro {

	int maxContatos;
	
	List<IContato> agenda = new ArrayList<>(maxContatos);
	
	@Override
	public boolean resetAgenda(int maxContatos) {
		
		this.maxContatos = maxContatos;
		this.agenda.clear();
		return true;
	}

	@Override
	public boolean adicionarContato(String telefone, String nome) {
		
		Contato contato = new Contato(); // Cria uma Conta 		
		
		if(this.agenda.size() >= this.maxContatos){ // Verificando o tamanho da agenda
			return false;
		}
			
		for (int i = 0; i < this.agenda.size(); i++) {	//Verifica se tem numero igual
			
			if(this.agenda.get(i).getTelefone().equals(telefone)){
				return false;
			}
		}
		
		//Mando 'telefone' e 'nome' para verificar os requisitos
		// para o cadastro de cada um
		if(verificarRequisitos(telefone,nome)){
			
			/* Se tudo isso ocorrer bem, adc telefone */
			contato.setTelefone(telefone);
			contato.setNome(nome);	
			
			/* Apos tudo isso ocorrer bem, adc o contato */
			this.agenda.add(contato); 
			
			return true;
		}
		return false;
		
	}

	@Override
	public IContato getContatoByTel(String telefone) {
		
		Contato contato = new Contato();
			
		for (int i = 0; i < this.agenda.size(); i++) {	//Verifica se tem numero igual
			
			if(telefone == this.agenda.get(i).getTelefone()){
				
				 contato.setNome(this.agenda.get(i).getNome());
				 contato.setTelefone(this.agenda.get(i).getTelefone());
				
				 return contato;
			}
		}
		
		return null;
	}

	@Override
	public boolean atualizarContato(String telefone, String nome) {
			
		//Verificar requisitos 
		if(!verificarRequisitos(telefone, nome)){
			return false;
		}
		
		for(int i = 0; i < this.agenda.size(); i ++){
			if(this.agenda.get(i).getTelefone().equals(telefone)){
				
				this.agenda.get(i).setNome(nome);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean removerContato(String telefone) {
		
		for(int i = 0; i < this.agenda.size(); i ++){
			if(this.agenda.get(i).getTelefone().equals(telefone)){
				
				this.agenda.remove(i);
				
				return true;
			}
		}
		return false;
	}

	@Override
	public List<IContato> getContatos() {
		return agenda;
	}

	@Override
	public List<String> getTelefones(String contato) {
	
		List<String> celefone = new ArrayList<>();
		
		for(int i = 0; i < agenda.size() ; i++){
			if(agenda.get(i).getNome().equals(contato)){
				celefone.add(agenda.get(i).getNome());
			}
		}
		
		if(!celefone.isEmpty()){
			return celefone;
		}
		
		return null;
	}

	private boolean verificarRequisitos (String telefone, String nome){
		
		// Nome nao pode ser null e nem telefone
		if(nome == null || telefone == null || nome.equals("") || telefone.equals("")){
			return false;
		}
		
		char[] ctelefone = telefone.toCharArray(); // Transforma em um vetor de Char
		
		for(int i = 0; i < ctelefone.length; i++){
			if(Character.isDigit(ctelefone[i]) == false){ // Olha se é apenas digito
				 return false;
			}
		}
		
		return true;
	}

}
