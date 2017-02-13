package aluno;

import cliente.IContato;

public class Contato implements IContato {

	private String nome;
	private String telefone;
	
	//List<String> allTelefones = new ArrayList<>();
	
	@Override
	public String getNome() {
		
		return this.nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getTelefone() {
		
		return this.telefone;
	}

	@Override
	public void setTelefone(String telefone) {
		
		this.telefone = telefone;
	}
	
	
}
