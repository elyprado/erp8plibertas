package erp.libertas.shared;

import java.io.Serializable;
import java.util.Date;

public class Pagar implements Serializable{

	private int idpagar;
	private Date dataLancto;
	private Date dataVencimento;
	private Fornecedor fornecedor;
	private double valor;
	private double valorPago;
	private Date dataPagamento;
	private String descricao;
	
	
	public int getIdpagar() {
		return idpagar;
	}
	public void setIdpagar(int idpagar) {
		this.idpagar = idpagar;
	}
	public Date getDataLancto() {
		return dataLancto;
	}
	public void setDataLancto(Date dataLancto) {
		this.dataLancto = dataLancto;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
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
	public Date getDataPagamento(){
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
