package erp.libertas.shared;

import java.io.Serializable;

public class Produto implements Serializable{
	private int idProduto;
	private String descricao;
	private String marca;
	private double preco;
	private int saldoEstoque;
	private String codBarras;
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getSaldoEstoque() {
		return saldoEstoque;
	}
	public void setSaldoEstoque(int saldoEstoque) {
		this.saldoEstoque = saldoEstoque;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	
	
}
