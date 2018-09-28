package erp.libertas.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import erp.libertas.server.bd.Conexao;
import erp.libertas.shared.Banco;

public class BancoDao {

    public List<Banco> listar() {
	List<Banco> lista = new ArrayList<Banco>();
	Conexao con = new Conexao();
	try {
		String sql = "SELECT "
				+ "idbanco,"
				+ "nome "
				+ "FROM banco";
		Statement sta = con.getConexao().createStatement();
		ResultSet res = sta.executeQuery(sql);
		while (res.next()) {
			Banco b = new Banco();
			b.setIdBanco(res.getInt("idbanco"));
			b.setNome(res.getString("nome"));
			lista.add(b);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	con.desconecta();
	return lista;
}
	
    public void inserir(Banco b) {
	Conexao con = new Conexao();
	try {
		String sql = "INSERT INTO banco "
				+ "(nome) "
				+ " VALUES (?)";
		PreparedStatement sta = con.getConexao().prepareStatement(sql);
		sta.setString(1, b.getNome());
		sta.execute();			
	} catch (Exception e) {
		e.printStackTrace();
	}
	con.desconecta();
}
	
    public void alterar(Banco b) {
	Conexao con = new Conexao();
	try {
		String sql = "UPDATE banco SET "
				+ "nome = ?"
				+ "WHERE idbanco = ?";
		PreparedStatement sta = con.getConexao().prepareStatement(sql);
		sta.setString(1, b.getNome());
		sta.execute();			
	} catch (Exception e) {
		e.printStackTrace();
	}
	con.desconecta();	
}
	
	public void excluir(Banco b) {
	Conexao con = new Conexao();
	try {
		String sql = "DELETE FROM banco "
				+ "WHERE idbanco = ?";
		PreparedStatement sta = con.getConexao().prepareStatement(sql);
		sta.setInt(1, b.getIdBanco());
		sta.execute();			
	} catch (Exception e) {
		e.printStackTrace();
	}
	con.desconecta();
	}
	
}
