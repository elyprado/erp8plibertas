package erp.libertas.shared;

import java.io.Serializable;
import java.util.Date;

public class Caixa implements Serializable {
    private int idCaixa;
    private String data;
    private double valor;
    private String descricao;
    private String planoDeContas;
    private Banco banco;
    
    public int getIdCaixa() {
        return idCaixa;
    }
    
    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getPlanoDeContas() {
        return planoDeContas;
    }
    
    public void setPlanoDeContas(String planoDeContas) {
        this.planoDeContas = planoDeContas;
    }
    
    public Banco getBanco() {
        return banco;
    }
    
    public void setBanco(Banco banco) {
        this.banco = banco;
    }

}
