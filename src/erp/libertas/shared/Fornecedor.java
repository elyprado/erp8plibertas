package erp.libertas.shared;

import java.io.Serializable;

public class Fornecedor implements Serializable {
	private int idfornecedor;
	private String nome;
	private String endereco;
	private String telefone;
	private Cidade cidade;
	
	public int getIdfornecedor() {
		return idfornecedor;
	}
	public void setIdfornecedor(int idfornecedor) {
		this.idfornecedor = idfornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
}
