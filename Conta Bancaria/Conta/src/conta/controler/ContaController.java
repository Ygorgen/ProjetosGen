package conta.controler;

import java.util.ArrayList;

import conta.model.conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {
	private ArrayList<conta> listacontas = new ArrayList<conta>();
	int numero = 0;

	@Override
	public void procurarpornumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA conta numero: " + numero + " não foi encontrada!");
		// TODO Auto-generated method stub

	}

	@Override
	public void listartodas() {
		for (var conta : listacontas) {
			conta.visualizar();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void cadastrar(conta conta) {
		// TODO Auto-generated method stub
		listacontas.add(conta);
		System.out.println("Conta numero: " + conta.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		if (buscaConta != null) {
			listacontas.set(listacontas.indexOf(buscaConta), conta);
			System.out.println("\nA conta numero: " + conta.getNumero() + " foi atualizada");
		} else
			System.out.println("\nA conta numero: " + conta.getNumero() + " não foi encontrada!");

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta != null) {
			if (listacontas.remove(conta) == true)
				;
			System.out.println("\nA conta numero: " + numero + " foi deletada com sucesso!");
		} else
			System.out.println("\nA conta numero; " + numero + " não foi encontrada");
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		if(conta!=null) {
			if(conta.sacar(valor)==true)
				System.out.println("\nO saque na conta: "+numero+" foi efetuado com sucesso!");
		}else 
			System.out.println("\nA conta numero: "+numero+" não foi encontrada!");
			
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
	    var conta = buscarNaCollection(numero);
	    if (conta != null) {
	        conta.depositar(valor); 
	        System.out.println("\nDepósito de R$" + valor + " na conta número " + numero + " foi efetuado com sucesso!");
	    } else {
	        System.out.println("\nA conta número " + numero + " não foi encontrada!");
	    }
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
	    var contaOrigem = buscarNaCollection(numeroOrigem);
	    var contaDestino = buscarNaCollection(numeroDestino);

	    if (contaOrigem != null && contaDestino != null) {
	        if(contaOrigem.sacar(valor)==true) {
	        	contaDestino.depositar(valor);
	        	System.out.println("\nTransferência efetuada co sucesso! ");
	        }else
	        	System.out.println("\nA conta de origem e/ou destino não foram encontrados");
	    }
	}

	public int gerarnumero() {
		return ++numero;

	}

	public conta buscarNaCollection(int numero) {
		for (var conta : listacontas) {
			if (conta.getNumero() == numero) {

				return conta;
			}
		}
		return null;
	}

	public int retornaTipo(int numero) {
		for (var conta : listacontas) {
			if (conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		return 0;
	}

}
