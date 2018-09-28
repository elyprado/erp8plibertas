package erp.libertas.shared;

import java.io.Serializable;

public class Banco implements Serializable {
    
    private int idBanco;
    private String nome;

    public int getIdBanco() {
	return idBanco;
    }
    public void setIdBanco(int idBanco) {
    	this.idBanco = idBanco;
    }
    public String getNome() {
    	return nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }

}
