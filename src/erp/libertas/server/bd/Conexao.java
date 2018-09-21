package erp.libertas.server.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private Connection conexao;
	
	public Conexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://erp8plibertas.cellbpjnzlmj.us-west-2.rds.amazonaws.com/erp?useTimezone=true&serverTimezone=UTC";
			conexao = DriverManager.getConnection(url,"libertas","passaafolha");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void desconecta() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	
}
