package erp.libertas.shared;

import java.io.Serializable;

public class Cidade implements Serializable {
	private int idcidade;
	private String nome;
	private String uf;
	public int getIdcidade() {
		return idcidade;
	}
	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
