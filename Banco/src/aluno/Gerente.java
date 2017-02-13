package aluno;

public class Gerente {
	//Ele fez a class Gerente para testar.

	public static void main(String[] args) {
		
		Conta CPai = new Conta(07,1000);
		Conta CMae = new Conta(10,500);
//		Gerente tem 2 contas
		
		
		CMae.sacar(30);
		CPai.sacar(500);
		CPai.transferir(CMae, 200);
		
		System.out.println("Mãe " + CMae.getExtrato());
		System.out.println("Pai " + CPai.getExtrato());
		System.out.println();
		System.out.println("Pai:Saldo " + CPai.getSaldo());
		System.out.println("Mae:Saldo " + CMae.getSaldo());
		
		//Para o Gerente observar, iremos criar uma class anonima
		IObserve obsMalandragem = new IObserve(){
			@Override
			public void ObsSaque(int id, double valor) {
				if(valor > 100.0)
					System.out.println("\n" + id + " sacou " + valor);
			}
			@Override
			public void ObsDeposito(int id, double valor) {
				if(valor > 100)
					System.out.println("\n" + id + " depositou " + valor);
			}
		}; // Class anonima
		
		
	
		CMae.atribuir(obsMalandragem);
		CMae.depositar(500);
		CPai.atribuir(obsMalandragem);
		CPai.sacar(300);
	
		System.out.println();
		
		CMae.desatribuir(obsMalandragem);
		CPai.depositar(400);
		CMae.depositar(800);
	
		System.out.println();
		
		System.out.println("Pai:Saldo " + CPai.getSaldo());
		System.out.println("Mae:Saldo " + CMae.getSaldo());

	}
}
