package dados;

public class Conta {
	String nome, CPF, profissao, rua, cidade, UF;
	int nCasa;
	double renda;

	/* CONSTRUTOR */
	public Conta(String nome, String CPF, String profissao, double renda, String rua, int nCasa, String cidade,
			String UF) {
		this.nome = nome;
		this.CPF = CPF;
		this.profissao = profissao;
		this.rua = rua;
		this.cidade = cidade;
		this.UF = UF;
		this.nCasa = nCasa;
		this.renda = renda;

	}

	/* GETERS E SETERS */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getCPF() {
		return CPF;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getRua() {
		return rua;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setUF(String UF) {
		this.UF = UF;
	}

	public String getUF() {
		return UF;
	}

	public void setNCasa(int nCasa) {
		this.nCasa = nCasa;
	}

	public int getNCasa() {
		return nCasa;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public double getRenda() {
		return renda;
	}

}
