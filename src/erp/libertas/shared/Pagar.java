package erp.libertas.shared;

import java.io.Serializable;


public class Pagar implements Serializable{

	private int idpagar;
	private String dataLancto;
	private String dataVencimento;
	private Fornecedor fornecedor;
	private double valor;
	private double valorPago;
	private String dataPagamento;
	private String descricao;
	
	
	public int getIdpagar() {
		return idpagar;
	}
	public void setIdpagar(int idpagar) {
		this.idpagar = idpagar;
	}
	public String getDataLancto() {
		return dataLancto;
	}
	public void setDataLancto(String dataLancto) {
		this.dataLancto = dataLancto;
	}
	public String getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	public String getDataPagamento(){
		return dataPagamento;
	}
	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
