package cliente;

import java.util.List;

import controle.ContatoPlus;
import controle.GerenciaContato;

public interface ITelefone {
	
//PARTE 1 Contatos
	//cada nome de contato eh unico
	boolean addContato(Contato contato);
	boolean rmContato(String contato);
	Contato getContato(String contato);
	
	//retorna todos os contatos ORDENADOS POR NOME
	List<Contato> getListContatos();
	
	//atualiza o contato, mudando nome e telefones
	//da erro se o nome antigo n�o existir ou o novo nome n�o existir
	//mantenha os valores de favoritos e contagem de liga��es
	boolean atualizarContato(String nomeAntigo, Contato contato);


//PARTE 2 Telefones	
	//adiciona um telefone ao contato
	boolean addTelContato(String contato, String telefone);
	//remove o telefone do contato
	boolean rmTelContato(String contato, String telefone);
	
//Parte 3 Favoritar
	//favorita um contato
	boolean favoritar(String nome);
	boolean desfavoritar(String nome);
	
	//pegar a lista ordenado por nome
	List<Contato> getFavoritos();
	
//Parte 4 Ligar
	//O objetivo dessa parte � saber quem s�o os contatos
	//mais ligados e colocalos numa lista especial
	//Cada vez que um contato for ligado voc� deve registrar.
	
	//ordena os contatos pela quantidade de liga��es
	//retorna os qtd contatos mais ligados
	List<Contato> getMaisLigados(int qtd);

	//Se esse telefone bater com o telefone de um contato
	//marque mais uma ocorrencia de ligacao nesse contato. 
	//Se mais de um contato tiver o mesmo telefone, marque apenas
	//ocorrencia no primeiro que aparecer na ordem lexicogr�fica
	void ligar(String telefone);
	
	//retorna os ultimos qantidade de contatos mais ligados.
	//as ultimas ligaa��es devem aparecer primeiro na lista
	//Se n existir n�mero correspondente ao contato
	//retorne um contato com o numero no nome e no numero
	//Fa�a da mesma forma para contatos que foram apagados
	//depois da liga��o
	List<Contato> getHistorico(int qtd);
	
	//limpa o histo
	void limparHistorico();
	
}
