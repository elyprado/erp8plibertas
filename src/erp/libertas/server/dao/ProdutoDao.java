package erp.libertas.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import erp.libertas.server.bd.Conexao;
import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Produto;

public class ProdutoDao {
	public List<Produto> listar() {
		List<Produto> lista = new ArrayList<Produto>();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT "
					+ "idProduto,"
					+ "descricao,"
					+ "marca,"
					+ "preco,"
					+ "saldoEstoque,"
					+ "codBarras"
					+ "FROM produtos";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Produto p = new Produto();
				p.setIdProduto(res.getInt("idProduto"));
				p.setDescricao(res.getString("descricao"));
				p.setMarca(res.getString("marca"));
				p.setPreco(res.getDouble("preco"));
				p.setSaldoEstoque(res.getInt("saldoEstoque"));
				p.setCodBarras(res.getString("codBarras"));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	
	public void inserir(Produto p) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO produtos "
					+ "(descricao, marca, preco, saldoEstoque, codBarras) "
					+ " VALUES (?, ?, ?, ?, ?)";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, p.getDescricao());
			sta.setString(2, p.getMarca());
			sta.setDouble(3, p.getPreco());
			sta.setInt(4, p.getSaldoEstoque());
			sta.setString(5, p.getCodBarras());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	
	public void alterar(Produto p) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE produtos SET "
					+ "descricao = ?, "
					+ "marca = ?,"
					+ "preco = ?,"
					+ "saldoEstoque = ? "
					+ "codBarras = ? "
					+ "WHERE idProduto = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, p.getDescricao());
			sta.setString(2, p.getMarca());
			sta.setDouble(3, p.getPreco());
			sta.setInt(4, p.getSaldoEstoque());
			sta.setString(5, p.getCodBarras());
			sta.setInt(6, p.getIdProduto());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();	
	}
	
	public void excluir(Produto p) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM produtos "
					+ "WHERE idProduto = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setInt(1, p.getIdProduto());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
}

