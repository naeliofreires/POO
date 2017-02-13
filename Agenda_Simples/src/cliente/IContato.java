package cliente;


public interface IContato {
	
	String getNome();
	void setNome(String nome);
	String getTelefone();
	void setTelefone(String telefone);
	//concatene nome e telefone "Fulano - 32232323"
	String toString();
}