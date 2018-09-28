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
				r.setCliente = c;
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
					+ "( "
					+ "  dataLancto ,"
			+ "  dataVencimento ,"
			+ "  idcliente ,"
			+ "  valor ,"
			+ "  valorPago ,"
			+ "  dataPagamento ,"
			+ "  descricao) "
					+ " VALUES (?, ?, ?, ?,?, ?, ?)";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, f.getDataLancto());
			sta.setString(2, f.getDataVencimento());
			sta.setString(3, f.getCliente().getIdCliente());
			sta.setDouble(4, f.getValor());
			sta.setDouble(5, f.getValorPago());
			sta.setString(6, f.getDataPagamento);
			sta.setString(7, f.getDescricao);
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
					+ "  dataLancto = ? ,"
					+ "  dataVencimento = ? ,"
					+ "  idcliente = ? ,"
					+ "  valor = ? ,"
					+ "  valorPago = ? ,"
					+ "  dataPagamento = ? ,"
					+ "  descricao = ? "
					+ "WHERE idreceber = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, f.getDataLancto());
			sta.setString(2, f.getDataVencimento());
			sta.setString(3, f.getCliente().getIdCliente());
			sta.setDouble(4, f.getValor());
			sta.setDouble(5, f.getValorPago());
			sta.setString(6, f.getDataPagamento);
			sta.setString(7, f.getDescricao);
			sta.setInt(8, f.getIdReceber());
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
