package erp.libertas.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import erp.libertas.server.bd.Conexao;
import erp.libertas.shared.Cidade;
import erp.libertas.shared.Compra;
import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Produto;

public class CompraDao {
	public List<Compra> listar() {
		List<Compra> lista = new ArrayList<Compra>();
		Conexao con = new Conexao();
		try {
		    String sql = "SELECT "
		    	+ "idCompra, qtdCompra,"
		    	+ "valorUnitario, valorTotal,"
		    	+ "numNotaFiscal, datacompra FROM Compra";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Fornecedor f = new Fornecedor();
				Compra c = new Compra();
				c.setIdCompra(res.getInt("idCompra"));
				c.setQtd(res.getInt("qtdCompra"));
				c.setValorUnitario(res.getDouble("valorUnitario"));
				c.setValorTotal(res.getDouble("valorTotal"));
				c.setNumNotaFiscal(res.getInt("numnotafiscal"));
				c.setData(res.getString("dataCompra"));
				lista.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	public void inserir(Compra c) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO Compra "
					+ "(idCompra, DataCompra, idFornecedor, idProduto, QtdCompra, ValorUnitario, ValorTotal, NumNotaFiscal) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setInt(1, c.getIdCompra());
			sta.setString(2, c.getData());
			sta.setInt(3, c.getFornecedor().getIdfornecedor());
			sta.setInt(4, c.getProduto().getIdProduto());
			sta.setInt(5, c.getQtd());
			sta.setDouble(6, c.getValorUnitario());
			sta.setDouble(7, c.getValorTotal());
			sta.setInt(8, c.getNumNotaFiscal());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	public void alterar(Compra c) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE Compra SET "
					+ "DataCompra = ?,"
					+ "idFornecedor = ?,"
					+ "QtdCompra = ? "
					+ "ValorUnitario = ?"
					+ "ValorTotal = ?"
					+ "NumNotaFiscal = ?"
					+ "WHERE idCompra = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, c.getData());
			sta.setInt(2, c.getFornecedor().getIdfornecedor());
			sta.setInt(3, c.getQtd());
			sta.setDouble(4, c.getValorUnitario());
			sta.setDouble(5, c.getValorTotal());
			sta.setInt(6, c.getNumNotaFiscal());
			sta.setInt(7, c.getIdCompra());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();	
	}
	public void excluir(Compra c) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM Compra "
					+ "WHERE idCompra = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setInt(1, c.getIdCompra());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
}
