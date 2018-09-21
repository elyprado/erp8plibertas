package erp.libertas.server.bd;

import java.sql.ResultSet;
import java.sql.Statement;

public class EstruturaBD {
	public static void main(String[] args) {
		System.out.println("Estrutura da BD");
		try {
			Conexao con = new Conexao();
			
			String sql = "CREATE TABLE IF NOT EXISTS cidade ("
					+ "idcidade int primary key auto_increment,"
					+ "nome varchar(50),"
					+ "uf varchar(2))";
			Statement sta = con.getConexao().createStatement();
			sta.execute(sql);
			
			/*sql = "INSERT INTO cidade (nome, uf) VALUES"
					+ "('S�o Sebasti�o do Para�so','MG')";
			sta.execute(sql);
			*/

			sql = "CREATE TABLE IF NOT EXISTS fornecedor ("
					+ "idfornecedor int primary key auto_increment,"
					+ "nome varchar(50),"
					+ "endereco varchar(50),"
					+ "idcidade int,"
					+ "telefone varchar(20),"
					+ "constraint foreign key (idcidade) references cidade(idcidade) )";
			sta.execute(sql);
			
			//Criação da tabela Produtos - Adenilson/Tiago
			sql = "CREATE TABLE IF NOT EXISTS produtos ("
					+ "idProduto int primary key auto_increment,"
					+ "descricao char(100),"
					+ "marca char(100))"
					+ "preco double"
					+ "saldoEstoque int"
					+ "codBarras char(30)"
					;
			sta = con.getConexao().createStatement();
			sta.execute(sql);
			
			con.desconecta();
			System.out.println("fim");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
