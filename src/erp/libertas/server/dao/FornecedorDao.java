package erp.libertas.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import erp.libertas.server.bd.Conexao;
import erp.libertas.shared.Cidade;
import erp.libertas.shared.Fornecedor;

public class FornecedorDao {
	public List<Fornecedor> listar() {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		Conexao con = new Conexao();
		try {
		    String sql = "SELECT "
				+ "f.idfornecedor, f.nome,"
				+ "f.telefone, f.endereco,"
				+ "c.idcidade, c.nome as cidade,"
				+ "c.uf "
				+ "FROM fornecedor f "
				+ "INNER JOIN cidade c ON f.idcidade = c.idcidade";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Cidade c = new Cidade();
				Fornecedor f = new Fornecedor();
				c.setIdcidade(res.getInt("idcidade"));
				c.setNome(res.getString("cidade"));
				c.setUf(res.getString("uf"));
				f.setCidade(c);
				f.setEndereco(res.getString("endereco"));
				f.setIdfornecedor(res.getInt("idfornecedor"));
				f.setNome(res.getString("nome"));
				f.setTelefone(res.getString("telefone"));
				lista.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	public void inserir(Fornecedor f) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO fornecedor "
					+ "(nome, telefone, endereco, idcidade) "
					+ " VALUES (?, ?, ?, ?)";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, f.getNome());
			sta.setString(2, f.getTelefone());
			sta.setString(3, f.getEndereco());
			sta.setInt(4, f.getCidade().getIdcidade());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	public void alterar(Fornecedor f) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE fornecedor SET "
					+ "nome = ?, "
					+ "telefone = ?,"
					+ "endereco = ?,"
					+ "idcidade = ? "
					+ "WHERE idfornecedor = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, f.getNome());
			sta.setString(2, f.getTelefone());
			sta.setString(3, f.getEndereco());
			sta.setInt(4, f.getCidade().getIdcidade());
			sta.setInt(5, f.getIdfornecedor());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();	
	}
	public void excluir(Fornecedor f) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM fornecedor "
					+ "WHERE idfornecedor = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setInt(1, f.getIdfornecedor());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
}
