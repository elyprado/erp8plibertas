package erp.libertas.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import erp.libertas.server.bd.Conexao;
import erp.libertas.shared.Cliente;
import erp.libertas.shared.Receber;

public class ReceberDao {

public class ReceberDao {
	public List<Receber> listar() {
		List<Receber> lista = new ArrayList<Receber>();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT *"
					+ "FROM receber r "
					+ "INNER JOIN Cliente c ON r.idCliente = c.idclient";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Cliente c = new Cliente();
				Receber r = new Receber();
				r.set
				lista.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	public void inserir(Receber f) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO receber "
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
	public void alterar(Receber f) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE receber SET "
					+ "nome = ?, "
					+ "telefone = ?,"
					+ "endereco = ?,"
					+ "idcidade = ? "
					+ "WHERE idreceber = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, f.getNome());
			sta.setString(2, f.getTelefone());
			sta.setString(3, f.getEndereco());
			sta.setInt(4, f.getCidade().getIdcidade());
			sta.setInt(5, f.getIdreceber());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();	
	}
	public void excluir(Receber f) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM receber "
					+ "WHERE idreceber = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setInt(1, f.getIdreceber());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}}
}
