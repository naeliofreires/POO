package aluno;

import java.util.List;

public interface IConta {
	// Retorna o número da conta
    public int getNumeroConta();

    // Retorna o saldo atual da conta
    public double getSaldo();

    // Deposita se valor não for negativo
    public boolean depositar(double valor);

    // Saca se saldo suficiente e o valor não for negativo
    public boolean sacar(double value);
    
    // Retira da conta atual para conta passada por parametro
    // apenas se existe saldo, valor não é negativo e conta está instanciada.
    public boolean transferir(IConta conta, double valor);

	/* Retorna o relatório de transações da conta
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
    List<Double> getExtrato();
}
