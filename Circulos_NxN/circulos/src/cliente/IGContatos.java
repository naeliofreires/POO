package cliente;

import java.util.List;


public interface IGContatos{
	//o id eh o nome do contato
	public class Contato{
		public String id, email;

		public Contato(String id, String email) {
			this.id = id;
			this.email = email;
		}
		
		public boolean equals(Object obj) {
			if(obj instanceof Contato){
				Contato other = (Contato) obj;
				return (this.id.equals(other.id) && 
						this.email.equals(other.email));
			}
			return false;
		}
	}
	
	//O id eh o nome do circulo
	//O limite define quantos contatos podem ser adicionados nesse circulo
	public class Circulo{
		public String id;
		public int limite;
		
		public Circulo(String id, int limite){
			this.id = id;
			this.limite = limite;
		}
		
		public boolean equals(Object obj) {
			if(obj instanceof Circulo){
				Circulo other = (Circulo) obj;
				return (this.id.equals(other.id) && 
					   (this.limite == other.limite));
			}
			return false;
		}
	}
	
//Parte 1 Contatos
	
    //Adiciona um contato na lista 
	//O id deve ser unico
	//o email deve ter um @
    boolean createContact(Contato contato);

    //retorna a lista com todos os contatos ORDENADOS POR NOME
    //Se os nomes forem iguais ordene pelos emails
    List<Contato> getAllContacts();
    
    //atualizar os valores de nome e email do contato com esse id
    boolean updateContact(Contato contato);

    //deteta um contato
    boolean removeContact(String idContato);

    //retorna um contato usando id
    Contato getContact(String idContato);

//Parte 2 Circulos
    
    //Adiciona um circulo
    //O id do circulo deve ser unico.
    //O limite define o maximo de contatos que esse circulo pode conter
    boolean createCircle(Circulo circulo);
    
    //altera um circulo desse id
    //se o circulo já contiver mais quantidades do que o máximo
    //permitido na atualização, não apague nenhum deles
    boolean updateCircle(Circulo circulo);

    Circulo getCircle(String idCirculo);
    
    //Pega a lista dos circulos ordenados pelo nome
    List<Circulo> getAllCircles();
    
    boolean removeCircle(String idCirculo);

//Parte 3 Relacoes
    
    //atribua um contato a um circulo se ele ainda couber
    boolean tie(String idContato, String idCirculo);
    //remove um contato de um circulo
    boolean untie(String idContato, String idCirculo);

    //retorna a lista de contatos ordenados por nome
    List<Contato> getContacts(String idCirculo);
    
    //retorna a lista de circulos ordenados por nome
    List<Circulo> getCircles(String idContato);
    
//Parte 4 Favoritos
    
    //favorita um contato se não estiver favoritado
    boolean favoriteContact(String idContato);
    boolean unfavoriteContact(String idContato);
    boolean isFavorited(String idContato);
    //retorna os contatos favoritados ordenados pelo nome
    List<Contato> getFavorited();
}












