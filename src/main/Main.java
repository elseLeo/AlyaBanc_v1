package main;

import java.util.Scanner;
import dados.Conta;
import dados.contaCorrente;
import menu.auxiliar;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		auxiliar menu = new auxiliar();
		String nome, user, rua, cpf, profissao, cidade, uf;
		int op = 0;
		int cont = 0, ciclo = 0, nCasa = 0, id = 0;
		double renda;
		boolean online = false;
		
		contaCorrente[] cc = new contaCorrente[10];

		while (ciclo == 0) {
			do {
				menu.menuInicial();
				op = Integer.parseInt(sc.nextLine());
				if (op == 1) {
					cc[cont] = new contaCorrente();
					System.out.println("===AlyaBank===");
					System.out.println("Informe seu nome:");
					nome = sc.nextLine();
					System.out.println("Informe seu CPF:");
					cpf = sc.nextLine();
					System.out.println("Informe sua profissão:");
					profissao = sc.nextLine();
					System.out.println("Informe sua renda:");
					renda = Double.parseDouble(sc.nextLine());
					System.out.println("Informe seu endereço:");
					System.out.println("Rua:");
					rua = sc.nextLine();
					System.out.println("Numero da casa:");
					nCasa = Integer.parseInt(sc.nextLine());
					System.out.println("Cidade:");
					cidade = sc.nextLine();
					System.out.println("Estado:");
					uf = sc.nextLine();
					/* MÉTODO CONSTRUTOR */
					Conta conta = new Conta(nome, cpf, profissao, renda, rua, nCasa, cidade, uf);

					cc[cont].setConta(conta);
					cc[cont].setAgencia("0101");
					cc[cont].setNumeroConta(cont + 1);
					cont += 1;
				} else if (op == 2) {
					System.out.println("Informe seu CPF");
					user = sc.next();
					if (cont == 0) {
						System.out.println("Usuario não cadastrado:");
						break;
					}
					for (int i = 0; i < cont; i++) {
						if (user.equals(cc[i].getConta().getCPF())) {
							online = true;
							id = i;
							break;
						} else {
							System.out.println("Usuario não cadastrado");
							online = false;
						}
					}
				} else if (op == 0) {
					System.out.println("AlyaBank agradece, até a proxima!!");
					System.exit(0);
				}
				while (online) {
					menu.menuPrincipal();
					op = sc.nextInt();
					switch (op) {
					case 1: {
						System.out.println("Informe o valor de deposito:");
						double valor = sc.nextDouble();
						cc[id].setSaldo(valor);
						System.out.printf("Deposito de %.2f efetuado!", valor);
						System.out.println("");
						cc[id].setPontos(valor * 0.001);
						break;
					}
					case 2: {
						System.out.println("Informe o valor do saque:");
						double valor = sc.nextDouble();
						if (cc[id].saque(valor)) {
							System.out.printf("Saque de %.2f efetuado!", valor);
							System.out.println("");
							cc[id].setPontos(valor * 0.001);
						} else {
							System.out.println("Não ha saldo suficiente para efetuar o saque");
						}
						break;
					}
					case 3: {
						System.out.println("Informe os seguintes dados:");
						System.out.println("Codigo do Banco:");
						int banco = sc.nextInt();
						System.out.println("Informe a agencia");
						int agencia = sc.nextInt();
						System.out.println("Informe o numero da conta:");
						int nConta = sc.nextInt();
						System.out.println("Informe o valor:");
						double valor = sc.nextDouble();
						if (cc[id].transferir(valor)) {
							System.out.println("Transferência efetuada com sucesso!");
							System.out.println("=====Extrato=====");
							System.out.println("Banco: " + banco);
							System.out.println("Banco: " + agencia);
							System.out.println("Banco: " + nConta);
							System.out.printf("Banco: R$%.2f", valor);
							System.out.println("");
							cc[id].setPontos(valor * 0.001);
							break;
						}
						if (valor > cc[id].getSaldo()) {
							System.out.println("Não ha saldo suficiente para efetuar a transferência");
						}
						break;
					}
					case 4: {
						System.out.printf("Seu saldo é R$%.2f", cc[id].getSaldo());
						System.out.println("");
						break;
					}
					case 5: {
						System.out.println("Deseja efetuar o parcelamento do boleto? 1- sim 2-nao");
						int op1 = sc.nextInt();
						if (op1 == 1) {
							System.out.println("=====AVISO=====");
							System.out.println("Para pagamentos parcelados, é necessário ter o valor de");
							System.out.println("uma parcela em conta, é cobrada uma taxa de 3% a.m");
							System.out.println("Informe o valor do boleto:");
							double valor = sc.nextDouble();
							System.out.println("Informe o numero de parcelas:");
							int parcela = sc.nextInt();
							System.out.printf("Parcelamento de " + parcela + "x R$%.2f",
									((valor * (parcela * 0.03) + valor) / parcela));
							System.out.println("");
							System.out.printf("Total: R$%.2f", (valor * (parcela * 0.03) + valor));
							System.out.println("");
							System.out.println("Deseja efetuar o pagamento? 1- sim 2-nao");
							int op2 = sc.nextInt();
							if (op2 == 1) {
								if (cc[id].pagamento((valor * (parcela * 0.03) + valor) / parcela)) {
									System.out.printf("Pagamento de R$%.2f efetuado!",
											(valor * (parcela * 0.03) + valor) / parcela);
									System.out.println("");
									cc[id].setPontos((valor * (parcela * 0.03) + valor) * 0.001);
								}
							}
							if (op2 == 2) {
								break;
							}
						}
						if (op1 == 2) {
							System.out.println("Informe o valor do boleto:");
							double valor = sc.nextDouble();
							if (cc[id].pagamento(valor)) {
								System.out.printf("Pagamento de %.2f efetuado!", valor);
								System.out.println("");
								cc[id].setPontos((valor * 0.001));
							} else {
								System.out.println("Não ha saldo suficiente para efetuar o saque");
							}
							break;
						}
						break;
					}
					case 6: {

						menu.menuPontos();
						int op6 = sc.nextInt();
						if (op6 == 1) {
							System.out.printf("Pontos: R$%.2f", cc[id].getPontos());
							System.out.println("");
							break;
						}
						if (op6 == 2) {
							System.out.printf("Valor disponível para resgate: R$" + cc[id].getPontos());
							System.out.println("");
							System.out.println("Informe o valor do resgate:");
							double valor = sc.nextDouble();
							if (cc[id].resgate(valor)) {
								System.out.printf("Resgate de %.2f efetuado!", valor);
								System.out.println("");
							} else {
								System.out.println("Não ha saldo suficiente para efetuar o resgate");
							}
							break;
						}
						break;
					}

					default:
						System.out.println("AlyaBank agradece, até a proxima!!");
						break;
					}
				}

			} while (op != 0);
		}
		sc.close();
	}
}
