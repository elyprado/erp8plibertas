package erp.libertas.shared;

import java.sql.Date;

public class Receber {
	private int idReceber;
	private Date dataLancto;
	private Date dataVencimento;
	private Cliente cliente;
	private double valor;
	private double valorPago;
	private Date dataPagamento;
	private String descricao;
	public int getIdReceber() {
		return idReceber;
	}
	public void setIdReceber(int idReceber) {
		this.idReceber = idReceber;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void txt(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
