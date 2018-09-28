package erp.libertas.server.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import erp.libertas.server.bd.Conexao;
import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Pagar;

public class PagarDao {
	
	public static void main(String[] args) {
		PagarDao dao = new PagarDao();
		List<Pagar> lista = dao.listar();
		for (Pagar pagar : lista) {
			System.out.println(pagar.getDescricao());
		}
		Pagar p = new Pagar();
		/*
		Fornecedor f = new Fornecedor();
		p.setDataLancto("13-12-1977");
		p.setDataPagamento("1900-02-02");
		p.setDescricao("1900-02-02");
		p.setDataVencimento("1900-02-02");
		f.setIdfornecedor(2);
		p.setValor(0);
		p.setValorPago(100);
		p.setFornecedor(f);
		dao.inserir(p);
		*/
		
		
	}
	
	
	
	public List<Pagar> listar() {
		List<Pagar> lista = new ArrayList<Pagar>();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT "
					+ " p.idPagar, p.dataLancto,"
					+ " p.dataVencimento, p.idfornecedor as fornecedor,"
					+ " p.valor, p.valorPago,"
					+ " p.dataPagamento, p.descricao "
					+ " FROM pagar p "
					+ " INNER JOIN fornecedor f ON p.idfornecedor = f.idfornecedor";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Pagar p = new Pagar();
				Fornecedor f = new Fornecedor();
				p.setIdpagar(res.getInt("idPagar"));
			    p.setDataLancto(res.getString("dataLancto"));
			    p.setDataVencimento(res.getString("dataVencimento"));
				p.setFornecedor(f);
				p.setValor(res.getDouble("valor"));
				p.setValorPago(res.getDouble("valorPago"));
				p.setDataPagamento(res.getString("dataPagamento"));
				p.setDescricao(res.getString("descricao"));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	public void inserir(Pagar p) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO pagar "
					+ "(dataLancto, dataVencimento, idfornecedor, valor, valorPago,"
					+ " dataPagamento, descricao) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, p.getDataLancto().toString());
			sta.setString(2, p.getDataVencimento().toString());
			sta.setInt(3, p.getFornecedor().getIdfornecedor());
			sta.setDouble(4, p.getValor());
			sta.setDouble(5, p.getValorPago());
			sta.setString(6, p.getDataPagamento().toString());
			sta.setString(7, p.getDescricao());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	public void alterar(Pagar p) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE Pagar SET "
					+ "dataLancto = ?, "
					+ "dataVencimento = ?,"
					+ "idfornecedor = ?,"
					+ "valor = ? ,"
					+ "valorPago = ? ,"
					+ "DataPagamento = ? ,"
					+ "descricao = ? ,"
					+ "WHERE idPagar = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, p.getDataLancto().toString());
			sta.setString(2, p.getDataVencimento().toString());
			sta.setInt(3, p.getFornecedor().getIdfornecedor());
			sta.setDouble(4, p.getValor());
			sta.setDouble(5, p.getValorPago());
			sta.setString(6, p.getDataPagamento().toString());
			sta.setString(7, p.getDescricao());
			sta.setInt(8, p.getIdpagar());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();	
	}
	public void excluir(Pagar p) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM pagar "
					+ "WHERE idPagar = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setInt(1, p.getIdpagar());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
}
