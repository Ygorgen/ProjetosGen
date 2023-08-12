package conta.model;

public class Contapoupanca extends conta {
	private int aniversario;

	public Contapoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario=aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário da conta: " + this.aniversario);
	}

}
