package cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import controle.ContatoPlus;
import controle.Telefone;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//HISTORICO - LINKED LIST
public class TesteUnidade {

	@Test
	public void AParte() {
		//Testes existência do telefone
		Telefone tel = new Telefone();
		assertTrue(tel.getListContatos().size() == 0);
		assertTrue(tel.getFavoritos().size() == 0); // NULL
		
		assertTrue(tel.addContato(new ContatoPlus("Rafael", "11", "12", "13")));
		assertTrue(tel.addContato(new ContatoPlus("Donatelo", "22", "25")));
				
		assertTrue(tel.getListContatos().size() == 2);
		
		assertTrue(tel.addContato(new ContatoPlus("Michelangelo", "31", "33", "35")));
		assertTrue(tel.addContato(new ContatoPlus("Leonardo", "41")));
		
		//pegando lista ordenada por nome
		List<Contato> lista = tel.getListContatos();
		assertEquals("Donatelo", lista.get(0).getNome());
		assertEquals("Leonardo", lista.get(1).getNome());
		assertEquals("Michelangelo", lista.get(2).getNome());
		assertEquals("Rafael", lista.get(3).getNome());
	}

	@Test
	public void BParte(){
		//Testes existência de manipulacao de teleones
		Telefone tel = new Telefone();
		assertTrue(tel.getListContatos().size() == 0);
		tel.addContato(new ContatoPlus ("Batman", "01", "02"));
		assertTrue(tel.addTelContato("Batman", "03"));
		
		//removendo telefones
		assertTrue(tel.rmTelContato("Batman", "01"));
		assertTrue(tel.rmTelContato("Batman", "03"));
		assertFalse(tel.rmTelContato("Batman", "03"));
		
		assertEquals("02", tel.getContato("Batman").getTelefones().get(0));
	}
	
	@Test
	public void CParte(){
		//Testes de favoritos
		Telefone agenda = new Telefone();
		assertTrue(agenda.getListContatos().size() == 0);
		assertTrue(agenda.getFavoritos().size() == 0); // NULL
		
		assertTrue(agenda.addContato(new ContatoPlus("Hulk", "111", "112")));	
		assertTrue(agenda.addContato(new ContatoPlus("Iron Man", "221", "222")));
		assertTrue(agenda.addContato(new ContatoPlus("Thor", "441", "442", "443")));

		//dois contatos com mesmo nome
		assertFalse(agenda.addContato(new ContatoPlus("Hulk", "11")));
		
		//favorita correto
		assertTrue(agenda.favoritar("Iron Man"));

		//nao favorita duas vezes a mesma pessoa
		assertFalse(agenda.favoritar("Iron Man"));
		
		//nao favorita quem nao existe
		assertFalse(agenda.favoritar("Iron Girl"));
		
		assertTrue(agenda.getFavoritos().size() == 1);
		
		assertTrue(agenda.desfavoritar("Iron Man"));

		//desfavoritar quem nao eh favorito
		assertFalse(agenda.desfavoritar("Iron Man"));
		//desfavoritar quem nao existe
		assertFalse(agenda.desfavoritar("Iron Girl"));
		
		assertTrue(agenda.favoritar("Hulk"));
		assertTrue(agenda.favoritar("Thor"));

		
		assertTrue(agenda.getFavoritos().size() == 2);
		assertTrue(agenda.rmContato("Hulk"));
		//remover pela segunda vez
		assertFalse(agenda.rmContato("Hulk"));
		assertTrue(agenda.getFavoritos().size() == 1);
		assertEquals("Thor", agenda.getFavoritos().get(0).getNome());
		
		//alterando para um nome que ja existe
		assertFalse(agenda.atualizarContato("Thor", new ContatoPlus("Iron Man", "55")));
		
		//alterando Thor para rex
		assertTrue(agenda.atualizarContato("Thor", new ContatoPlus("Rex", "11")));
		//verificando se Rex esta favoritado
		assertEquals("Rex", agenda.getFavoritos().get(0).getNome());
		assertEquals("11", agenda.getFavoritos().get(0).getTelefones().get(0));
	}
	
	@Test
	public void DParte(){
		//Teste de ligações
		Telefone telSimpsons = new Telefone();
		
		telSimpsons.addContato(new ContatoPlus("Homer", "00"));
		telSimpsons.addContato(new ContatoPlus("Bart", "11", "13"));
		telSimpsons.addContato(new ContatoPlus("Margie", "21", "23", "25"));
		telSimpsons.addContato(new ContatoPlus("Lisa", "31", "33", "35", "39"));
		
		//ligando 3 vezes Lisa, 2 vezes Homer, 1 vez Margie


		telSimpsons.ligar("00");
		
		telSimpsons.ligar("33");//Lisa
		telSimpsons.ligar("25");//Margie
		telSimpsons.ligar("00");//Homer
		telSimpsons.ligar("99");//nao ta na agenda
		telSimpsons.ligar("35");//Lisa
		telSimpsons.ligar("39");//Lisa

		
		List<Contato> lista = telSimpsons.getMaisLigados(3);
		assertEquals("Lisa", lista.get(0).getNome());
		assertEquals("Homer", lista.get(1).getNome());
		assertEquals("Margie", lista.get(2).getNome());
		
		telSimpsons.rmContato("Homer");
		telSimpsons.rmContato("Margie");
		
		//so tem 2, so pode retornar 2
		lista = telSimpsons.getMaisLigados(3);
		assertEquals("Lisa", lista.get(0).getNome());
		assertEquals("Bart", lista.get(1).getNome());
		
		telSimpsons.ligar("13");//Bart
		
		lista = telSimpsons.getHistorico(7);
		
		assertEquals("Bart", lista.get(0).getNome());
		assertEquals("Lisa", lista.get(1).getNome());
		assertEquals("Lisa", lista.get(2).getNome());
		assertEquals("99", lista.get(3).getNome());
		assertEquals("00", lista.get(4).getNome());
		assertEquals("25", lista.get(5).getNome());
		assertEquals("Lisa", lista.get(6).getNome());
		
		telSimpsons.limparHistorico();
		
		assertEquals(0, telSimpsons.getHistorico(4).size());
		
	}
}
