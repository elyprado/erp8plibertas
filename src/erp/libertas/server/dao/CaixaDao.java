package erp.libertas.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import erp.libertas.server.bd.Conexao;
import erp.libertas.shared.Banco;
import erp.libertas.shared.Caixa;

public class CaixaDao {

    public List<Caixa> listar() {
	List<Caixa> lista = new ArrayList<Caixa>();
	Conexao con = new Conexao();
	try {
		String sql = "SELECT "
				+ "c.idcaixa, c.data,"
				+ "c.valor, c.descricao, c.planoDeContas,"
				+ "b.idbanco, b.nome"
				+ "FROM caixa c "
				+ "INNER JOIN banco b ON c.banco_idbanco = b.idbanco";
		Statement sta = con.getConexao().createStatement();
		ResultSet res = sta.executeQuery(sql);
		while (res.next()) {
			Caixa c = new Caixa();
			Banco b = new Banco();
			b.setIdBanco(res.getInt("idbanco"));
			b.setNome(res.getString("nome"));
			c.setIdCaixa(res.getInt("idcaixa"));
			c.setData(res.getDate("data"));
			c.setValor(res.getDouble("valor"));
			c.setDescricao(res.getString("descricao"));
			c.setPlanoDeContas(res.getString("planoDeContas"));
			c.setBanco(b);
			lista.add(c);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	con.desconecta();
	return lista;
}
public void inserir(Caixa c) {
	Conexao con = new Conexao();
	try {
		String sql = "INSERT INTO Caixa "
				+ "(data, valor, descricao, planoDeContas, banco_idbanco) "
				+ " VALUES (?, ?, ?, ?, ?)";
		PreparedStatement sta = con.getConexao().prepareStatement(sql);
		sta.setString(1, c.getData().toString());
		sta.setDouble(2, c.getValor());
		sta.setString(3, c.getDescricao());
		sta.setString(4, c.getPlanoDeContas());
		sta.setInt(5, c.getBanco().getIdBanco());
		sta.execute();			
	} catch (Exception e) {
		e.printStackTrace();
	}
	con.desconecta();
}
public void alterar(Caixa c) {
	Conexao con = new Conexao();
	try {
		String sql = "UPDATE caixa SET "
				+ "data = ?, "
				+ "valor = ?,"
				+ "descricao = ?,"
				+ "planoDeContas = ?, "
				+ "banco_idbanco = ? "
				+ "WHERE idcaixa = ?";
		PreparedStatement sta = con.getConexao().prepareStatement(sql);
		sta.setString(1, c.getData().toString());
		sta.setDouble(2, c.getValor());
		sta.setString(3, c.getDescricao());
		sta.setString(4, c.getPlanoDeContas());
		sta.setInt(5, c.getBanco().getIdBanco());
		sta.setInt(5, c.getIdCaixa());
		sta.execute();			
	} catch (Exception e) {
		e.printStackTrace();
	}
	con.desconecta();	
}
public void excluir(Caixa c) {
	Conexao con = new Conexao();
	try {
		String sql = "DELETE FROM caixa "
				+ "WHERE idcaixa = ?";
		PreparedStatement sta = con.getConexao().prepareStatement(sql);
		sta.setInt(1, c.getIdCaixa());
		sta.execute();			
	} catch (Exception e) {
		e.printStackTrace();
	}
	con.desconecta();
	}

}
