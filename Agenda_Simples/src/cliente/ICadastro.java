package cliente;

import java.util.List;

public interface ICadastro {
	
	//Inicia a agenda apagando qualquer contato que nela possua.
	//Tamb√©m seta o limite da mem√≥ria para adicionar contatos.
	boolean resetAgenda(int maxContatos);
	
	//Adiciona um contato a agenda passando nome e telefone
	//Nao podem existir duas entradas com o mesmo telefone
	//
	//O telefone deve ser composto apenas de digitos.
	//O nome n√£o pode ser uma string vazia
	//
	//Se o contato foi adicionado com sucesso retorne true
	boolean adicionarContato(String telefone, String nome);
	
	//FunÁ„o que retorna o nome do contato a partir do seu telefone
	//Se o telefone n„o existir retorne null
	IContato getContatoByTel(String telefone);
	
	//Atualiza o contato com esse Telefone
	//Retorne false caso telefone n seja encontrado ou
	//nao esteja de acordo com os requisitos para adicionar um novo contato
	boolean atualizarContato(String telefone, String nome);
	
	//Remove o contato desse telefone
	boolean removerContato(String telefone);
	
	//devolve todos os telefones da lista
	List<IContato> getContatos();
	
	//Dado o nome de um contato retorne a lista de telefones
	//que ele possui. Caso o contato n exista, retorne null.
	List<String> getTelefones(String contato);
}
