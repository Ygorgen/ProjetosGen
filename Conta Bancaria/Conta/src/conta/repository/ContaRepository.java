package conta.repository;
import conta.model.conta;

public interface ContaRepository {
	public void procurarpornumero(int numero);
	public void listartodas();
	public void cadastrar (conta conta);
	public void deletar(int numero);
	
	//metodos bancarios
	
	public void sacar (int numero ,float valor);
	public void depositar (int numero , float valor);
	public void transferir (int numeroOrigem, int numeroDestino,float valor);
	


}
