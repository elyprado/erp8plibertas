package erp.libertas.shared;

import java.io.Serializable;

public class Compra implements Serializable{
	
	private int idCompra;
	private String data;
	private Fornecedor fornecedor;
	private Produto produto;
	private int qtd;
	private double valorUnitario;
	private double valorTotal;
	private int numNotaFiscal;
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getNumNotaFiscal() {
		return numNotaFiscal;
	}
	public void setNumNotaFiscal(int numNotaFiscal) {
		this.numNotaFiscal = numNotaFiscal;
	}
	
}
