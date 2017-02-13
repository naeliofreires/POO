package cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import aluno.GContatos;
import cliente.IGContatos.Circulo;
import cliente.IGContatos.Contato;

public class GContactsTestes {
	//classe de serviÃ§o principal
	private GContatos gcont;
	//circulos
	private Circulo familia, trabalho, amigos;
	//contatos
	private Contato jesus, jose, maria, ana, joaquim;
	
	//esse mÃ©todo Ã© executado antes de cada teste
	@Before
    public void setUp() {
        familia = new Circulo("familia", 3);
        trabalho = new Circulo("trabalho", 3);
        amigos = new Circulo("amigos", 1);

        jesus = new Contato("jesus", "jesus@ufc.com");
        jose = new Contato("jose", "jose@ufc.br");
        maria = new Contato("maria", "maria@ufc.br");
        ana = new Contato("ana", "ana@ufc.br");
        joaquim = new Contato("joaquim", "joaquim@ufc.br");
        
        gcont = new GContatos();
    }
	
	@Test
	public void aTesteCrud() {	
		//criacao
		assertTrue(gcont.createCircle(familia));
		assertTrue(gcont.createCircle(amigos));
		assertTrue(gcont.createCircle(trabalho));
		//criacao de entrada duplicada
		assertFalse(gcont.createCircle(new Circulo("trabalho", 5)));
		
		//get individual
		assertEquals(gcont.getCircle("familia"), familia);
		assertEquals(gcont.getCircle("inimigos"), null);
		
		//getAll deve retornar em ordem
		assertEquals(gcont.getAllCircles(), 
				Arrays.asList(amigos, familia, trabalho));
		
		//testando remocao
		assertFalse(gcont.removeCircle("pipoca"));
		assertTrue(gcont.removeCircle("amigos"));
		
		assertEquals(gcont.getAllCircles(), 
				Arrays.asList(familia, trabalho));
		
//		//testando update
		assertTrue(gcont.updateCircle(new Circulo("familia", 4)));
		assertEquals(gcont.getCircle("familia"), new Circulo("familia", 4));
		
	}

	@Test
	public void bTesteRelacoes(){
		
		//adicionando ao sistema
		assertTrue(gcont.createCircle(familia));
		assertTrue(gcont.createCircle(amigos));
		assertTrue(gcont.createCircle(trabalho));
		
		assertTrue(gcont.createContact(jesus));
		assertTrue(gcont.createContact(maria));
		assertTrue(gcont.createContact(jose));
		assertTrue(gcont.createContact(ana));
		assertTrue(gcont.createContact(joaquim));
		
		//criando relações
		assertTrue(gcont.tie("jesus", "familia"));
		assertTrue(gcont.tie("maria", "familia"));		
		assertTrue(gcont.tie("jose", "familia"));
		
		assertTrue(gcont.tie("jesus", "trabalho"));
		assertTrue(gcont.tie("joaquim", "trabalho"));
		assertTrue(gcont.tie("ana", "trabalho"));
		
		assertTrue(gcont.tie("jesus", "amigos"));
		
		//Testando gets e untie
		assertEquals(gcont.getCircles("jesus"), Arrays.asList(amigos, familia, trabalho));
		
		assertEquals(gcont.getContacts("trabalho"), Arrays.asList(ana, jesus, joaquim));
		
		//desligando jesus do trabalho e testando
		assertTrue(gcont.untie("jesus", "trabalho"));
		
		assertEquals(gcont.getCircles("jesus"), Arrays.asList(amigos, familia));
		
		assertEquals(gcont.getContacts("trabalho"), Arrays.asList(ana, joaquim));
		
		//REMOVENDO JOSE
		assertEquals(gcont.getContacts("familia"), Arrays.asList(jesus, jose, maria));
		
		assertTrue(gcont.removeContact("jose"));
		
		assertEquals(gcont.getContacts("familia"), Arrays.asList(jesus, maria));
		
		//REMOVENDO FAMILIA
		assertEquals(gcont.getCircles("jesus"), Arrays.asList(amigos, familia));
		
		assertTrue(gcont.removeCircle("familia"));
		
		assertEquals(gcont.getCircles("jesus"), Arrays.asList(amigos));
		
	}
	
	@Test
	public void CTesteFavoritos(){
		assertTrue(gcont.createContact(jesus));
		assertTrue(gcont.createContact(maria));
		assertTrue(gcont.createContact(jose));
		assertTrue(gcont.createContact(ana));
		assertTrue(gcont.createContact(joaquim));
	
		assertTrue(gcont.favoriteContact("jesus"));
		assertTrue(gcont.favoriteContact("ana"));
		assertTrue(gcont.favoriteContact("maria"));
		
		assertTrue(gcont.isFavorited("ana"));
		assertFalse(gcont.isFavorited("jose"));
		
		assertEquals(gcont.getFavorited(), 
				Arrays.asList(ana, jesus, maria));
		
		assertTrue(gcont.unfavoriteContact("ana"));
		
		assertEquals(gcont.getFavorited(), 
				Arrays.asList(jesus, maria));
		
		assertTrue(gcont.removeContact("maria"));
		
		assertEquals(gcont.getFavorited(), Arrays.asList(jesus));
		
	}

}
