package aluno;

import java.util.ArrayList;
import java.util.List;

//Faz uma interface Obersavadora 
 interface IObserve {
	 //Faz os m�todos que queira observar com os par�mentros necess�rio p/ sua ocasi�o.
	 void ObsSaque(int id, double valor);
	 void ObsDeposito(int id, double valor);
 }

public class Conta{
	
	List<IObserve> observadores;
	private int numeroConta;
	private double saldo;
	List<Double> extrato;
	
	//Construtor
	public Conta(int numeroConta, double saldoInicial) {
	
		this.numeroConta = numeroConta;
		this.saldo = saldoInicial;
		extrato = new ArrayList<>();
		observadores = new ArrayList<IObserve>();
	}
	
	// Retorna o n�mero da conta
    public int getNumeroConta() {
		return this.numeroConta;
	}

	// Retorna o saldo atual da conta
    public double getSaldo() {
		return this.saldo;
	}

	// Deposita se valor n for negativo
    public boolean depositar(float valor) {
    	
    	if(valor > 0){
    		this.saldo += valor;
    		this.extrato.add((double)valor);
    		for(IObserve x : this.observadores){
    			x.ObsDeposito(numeroConta, valor);
    		}
    		return true;
    	}
    	return false;
	}

	// Saca se saldo suficiente
    public boolean sacar(double value) {
    	
    	if(value > 0){
    		if(value <= this.saldo){
    			this.saldo -= value;
    			this.extrato.add(-value);
    			for(IObserve x : this.observadores){
    				x.ObsSaque(numeroConta, value);
    			}
    			return true;
    		}
    	}
    	return false;
	}
	
	// Saca da conta atual e deposita na conta passada por parametro.
	public boolean transferir(Conta conta, double valor) {
		
		if(conta != null){
			
			boolean resp = this.sacar(valor);
			
			if(resp == true){
				conta.depositar((float)valor);
				return true;
			}
		}
		
		return false;
	}

	/* Retorna o relatorio de transa��es da conta
	 * Os depósitos são valores positivos e os saques negativos.
	 * Transferências podem ser positivas ou negativas.
     * Ex.:
     * Inicio retorna uma lista vazia.
     * extrato = []
     * 
     * Depositou 20.0
     * extrato = [20.0]
     * 
     * Sacou 10.0
     * extrato = [20.0, -10.0]
     * 
     * Depositou 15.0
     * extrato = [20.0, -10.0, 15.0]
     * 
     * Sacou 8.0
     * extrato = [20.0, -10.0, 15.0, -8.0]
     * 
     * Recebeu uma transferencia de 40
     * 
     * extrato = [20.0, -10.0, 15.0, -8.0, 40]
     * 
     * Tranferiu 20
     * 
     * extrato = [20.0, -10.0, 15.0, -8.0, 40, -20]
     * 
     */
	public List<Double> getExtrato() {
		return extrato;
	}

	boolean atribuir(IObserve x){
		if(this.observadores.contains(x)) return false;
		
		return observadores.add(x);
	}
	
	boolean desatribuir(IObserve x){
		return this.observadores.remove(x);		
	}
	
}
