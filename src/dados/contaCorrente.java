package dados;

public class contaCorrente {
	/* ATRIBUTOS PRIVADOS */
	private int numConta;
	private String agencia;
	private double saldo, pontos;
	private Conta conta;

	/* GETERS E SETERS USADOS PARA ACESSAR OS ATRIBUTOS */
	public void setNumeroConta(int numeroConta) {
		this.numConta = numeroConta;
	}

	public int getNumeroConta() {
		return this.numConta;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getAgencia() {
		return this.agencia;
	}

	public void setSaldo(double saldo) {
		this.saldo += saldo;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Conta getConta() {
		return this.conta;
	}

	public void setPontos(double pontos) {
		this.pontos += pontos;
	}

	public double getPontos() {
		return pontos;
	}

	public boolean saque(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}

	public boolean transferir(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}

	public boolean pagamento(double parcela) {
		if (this.saldo >= parcela) {
			this.saldo -= parcela;
			return true;
		}
		return false;
	}
	public boolean resgate(double valor) {
		if (this.pontos >= valor) {
			this.pontos -= valor;
			this.saldo += valor;
			return true;
		}
		return false;
	}

}
