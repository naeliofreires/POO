package cliente;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import aluno.Cadastro;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestesCadastro {

	@Test
	public void aAdicaoContagem(){
		ICadastro cadastro = new Cadastro();
		cadastro.resetAgenda(4);
		
		assertTrue(cadastro.getContatos().size() == 0);
		assertTrue(cadastro.adicionarContato("11110000", "Pedro Ã�lvares"));
		assertTrue(cadastro.adicionarContato("11110010", "Dom Pedro"));
		//telefones diferentes, mesmo nome
		assertTrue(cadastro.adicionarContato("11110020", "Dom Pedro"));
		
		//telefone invalido
		assertFalse(cadastro.adicionarContato("a0", "Rio Branco"));
		assertFalse(cadastro.adicionarContato("00-19238", "Rio Branco"));
		//nome invalido
		assertFalse(cadastro.adicionarContato("00-19238", ""));
		//parametros nao instanciados
		assertFalse(cadastro.adicionarContato(null, "asdf"));
		
		//Inserir Telefone Duplicado
		assertFalse(cadastro.adicionarContato("11110020", "Rio Nilo"));
		
		assertTrue(cadastro.getContatos().size() == 3);
		
		assertTrue(cadastro.getContatoByTel("11110010")!=null);
		
		assertTrue(cadastro.adicionarContato("22220000", "Pedro Ã�lvares"));
		
		//acima do limite de 4
		assertFalse(cadastro.adicionarContato("22220010", "Dom Pedro"));
		
		cadastro.resetAgenda(5);
		
		assertTrue(cadastro.adicionarContato("11110040", "Pedro Ã�lvares"));
		assertTrue(cadastro.adicionarContato("11110050", "Dom Pedro"));
		assertTrue(cadastro.adicionarContato("11110060", "Dom Pedro"));
		assertTrue(cadastro.adicionarContato("11110070", "Pedro Ã�lvares"));
		
		assertTrue(cadastro.removerContato("11110040"));
		assertTrue(cadastro.getContatos().size()==3);
		
		
		//remover quem ja foi removido
		assertFalse(cadastro.removerContato("11110040"));
		assertTrue(cadastro.getContatos().size()==3);
		
		assertTrue(cadastro.adicionarContato("35420070", "Marechal Deororo"));
		assertTrue(cadastro.adicionarContato("35480080", "Joaquim Manoel"));
		assertTrue(cadastro.getContatos().size()==5);
		
		//atualizar
		assertTrue(cadastro.atualizarContato("35420070", "Fco"));
		assertFalse(cadastro.atualizarContato("35420070", ""));
		assertEquals(cadastro.getContatoByTel("35420070").getNome(), "Fco");
	}
	
	@Test
	public void cListasTelefones(){
		ICadastro cadastroTest = new Cadastro();
		cadastroTest.resetAgenda(10);
		
		assertTrue(cadastroTest.getContatos().size() == 0);
		assertTrue(cadastroTest.adicionarContato("11110000", "Pedro Ã�lvares"));
		assertTrue(cadastroTest.adicionarContato("11110010", "Dom Pedro"));
		assertTrue(cadastroTest.adicionarContato("11110020", "Rio Branco"));
		
		assertTrue(cadastroTest.getContatos().size() == 3);
		
		//procurando dom pedro
		assertEquals("Dom Pedro", cadastroTest.getContatoByTel("11110010").getNome());
		
		//procurando quem nao existe
		assertEquals(null, cadastroTest.getContatoByTel("8888"));
		
		assertTrue(cadastroTest.adicionarContato("22220000", "Pedro Ã�lvares"));
		assertTrue(cadastroTest.adicionarContato("33330000", "Pedro Ã�lvares"));
		
		assertTrue(cadastroTest.adicionarContato("22220010", "Dom Pedro"));
		assertTrue(cadastroTest.adicionarContato("22220020", "Rio Branco"));
		
		//Quantidade de telefones do Pedro
		assertTrue(cadastroTest.getTelefones("Pedro Ã�lvares").size()==3);
		
		//Ronildo nÃ£o tem telefone
		assertEquals(null,cadastroTest.getTelefones("Ronildo Oliveira"));
	}

}