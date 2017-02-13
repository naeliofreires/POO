package aluno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteConta {
	
	@Test
	public void testAbertura() {
		Conta conta = new Conta(7685, 100.0);
		
		assertTrue(conta.getNumeroConta() == 7685);
		assertEquals(conta.getSaldo(), 100.0, 0.01);
	}
	
	@Test
	public void testSaqueDeposito() {
		Conta conta = new Conta(7685, 100.0);
		
		assertFalse(conta.depositar(-10));
		assertTrue(conta.depositar(10));
		assertEquals(conta.getSaldo(), 110.0, 0.01);
		
		assertFalse(conta.sacar(-1));
		assertFalse(conta.sacar(150));
		assertTrue(conta.sacar(20));
		assertEquals(conta.getSaldo(), 90.0, 0.01);
	}
	
	@Test
	public void testTransferencia() {
		Conta A = new Conta(1, 100.0);
		Conta B = new Conta(2, 50.0);
		
		assertFalse(A.transferir(B, -1));
		assertFalse(A.transferir(null, 10));
		assertFalse(A.transferir(B, 200));
		assertTrue( A.transferir(B, 100));
		assertEquals(A.getSaldo(), 0, 0.01);
	}
	
	@Test
	public void testGetExtrato() {
		Conta conta = new Conta(1, 100.0);
		Conta contaB = new Conta(2, 100.0);
		
		assertTrue(conta.sacar(60));
		assertTrue(conta.depositar(50));
		assertTrue(conta.sacar(10));
		assertTrue(conta.depositar(5));
		assertTrue(conta.transferir(contaB, 1));
		assertTrue(contaB.transferir(conta, 3));
		assertEquals(conta.getSaldo(), 87, 0.01);
		
		List<Double> extrato = new ArrayList<Double>();
		extrato.add(-60.0);
		extrato.add(50.0);
		extrato.add(-10.0);
		extrato.add(5.0);
		extrato.add(-1.0);
		extrato.add(3.0);
		
		assertTrue(conta.getExtrato().equals(extrato));
	}
}
