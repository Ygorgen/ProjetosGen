package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controler.ContaController;
import conta.model.ContaCorrente;
import conta.model.Contapoupanca;
import conta.model.conta;
import conta.util.cores;

public class Menu {

	public static void main(String[] args) {
		ContaController contas = new ContaController();
		Scanner leia = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		System.out.println("\nCriar contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarnumero(), 123, 1, "João da Silva", 45000f, 3000);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarnumero(), 124, 1, "Maria da Silva", 45000f, 3000);
		contas.cadastrar(cc2);
		Contapoupanca cp1 = new Contapoupanca(contas.gerarnumero(), 125, 2, "Mariana dos santos", 4000f, 12);
		contas.cadastrar(cp1);
		Contapoupanca cp2 = new Contapoupanca(contas.gerarnumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listartodas();

		while (true) {

			System.out.println(cores.TEXT_YELLOW + cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(cores.TEXT_WHITE + "Criar Conta\n\n");

				System.out.println("Digite o numero da agencia");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o tipo de conta ( 1-Cc ou 2-Cp ): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite da conta: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarnumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversario da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new Contapoupanca(contas.gerarnumero(), agencia, tipo, titular, saldo, aniversario));

				}

				}
				keyPress();
				break;

			case 2:
				System.out.println(cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				contas.listartodas();
				keyPress();
				break;
			case 3:
				System.out.println(cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();
				contas.procurarpornumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				if (contas.buscarNaCollection(numero) != null) {

					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();

					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R");
					titular = leia.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();

					tipo = contas.retornaTipo(numero);

					switch (tipo) {
					case 1:
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						break;

					case 2:
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new Contapoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						break;

					default:
						System.out.println("Tipo de conta inválido!");
						break;
					}
				} else {
					System.out.println("\nConta não encontrada!");
					keyPress();
					break;
				}

			case 5:
				System.out.println(cores.TEXT_WHITE + "Apagar a Conta\n\n");
				System.out.println("Digite o numero da conta: ");
				numero=leia.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
				
			case 6:
				System.out.println(cores.TEXT_WHITE + "Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println(cores.TEXT_WHITE + "Depósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(cores.TEXT_WHITE + "Transferência entre Contas\n\n");
				keyPress();
				break;
			default:
				System.out.println(cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {
		System.out.println(cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		try {
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}