package erp.libertas.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import erp.libertas.client.cliente.ListaCliente;
import erp.libertas.server.bd.Conexao;
import erp.libertas.shared.Cidade;
import erp.libertas.shared.Cliente;
import erp.libertas.shared.Fornecedor;

public class ClienteDao {
	/*public static void main(String[] args) {
		ClienteDao cli = new ClienteDao();
		Cidade cidade = new Cidade();
		cidade.setIdcidade(1);
		Cliente c = new Cliente();
		c.setNome("Jailton");
		c.setBairro("Gggg");
		c.setCidade(cidade);
		c.setCpf("456666");
		c.setTelefone("889999");
		c.setEndereco("dasd");
		c.setEmail("sadsa");
		cli.inserir(c);
		
		
		
		
		
		List<Cliente> lista  = cli.listar();
		for (Cliente cliente : lista) {
			System.out.println(cliente.getNome());
		}
		
	}*/
	
	
	public List<Cliente> listar() {
		List<Cliente> lista = new ArrayList<Cliente>();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT "
					+ "cli.idcliente, cli.nome,"
					+ "cli.endereco, cli.bairro,"
					+ "c.idcidade, c.nome as cidade,"
					+ "c.uf,"
					+ "cli.telefone, cli.email,cli.cpf " 
					+ "FROM cliente cli "
					+ "INNER JOIN cidade c ON cli.idcidade = c.idcidade";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Cidade c = new Cidade();
				Cliente cliente = new Cliente();
				c.setIdcidade(res.getInt("idcidade"));
				c.setNome(res.getString("cidade"));
				c.setUf(res.getString("uf"));
				cliente.setCidade(c);
				cliente.setEndereco(res.getString("endereco"));
				cliente.setIdCliente(res.getInt("idCliente"));
				cliente.setNome(res.getString("nome"));
				cliente.setTelefone(res.getString("telefone"));
				cliente.setBairro(res.getString("bairro"));
				cliente.setEmail(res.getString("email"));
				cliente.setCpf(res.getString("cpf"));
				lista.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	public void inserir(Cliente cliente) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO cliente "
					+ "(nome,endereco,bairro,telefone,cpf, email,idcidade) "
					+ " VALUES (?, ?, ?, ?,?,?,?)";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, cliente.getNome());
			sta.setString(2, cliente.getEndereco());
			sta.setString(3, cliente.getBairro());
			sta.setString(4, cliente.getTelefone());
			sta.setString(5, cliente.getCpf());
			sta.setString(6, cliente.getEmail());
			sta.setInt(7, cliente.getCidade().getIdcidade());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	public void alterar(Cliente cliente) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE cliente SET "
					+ "nome = ?, "
					+ "telefone = ?,"
					+ "endereco = ?,"
					+ "bairro = ?,"
					+ "cidade= ?,"
					+ "email= ?,"
					+"cpf= ?,"
					+ "idcidade = ? "
					+ "WHERE idcliente = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setString(1, cliente.getNome());
			sta.setString(2, cliente.getTelefone());
			sta.setString(3, cliente.getEndereco());
			sta.setString(4, cliente.getBairro());
			sta.setString(5, cliente.getEmail());
			sta.setString(6, cliente.getCpf());
			sta.setInt(7, cliente.getCidade().getIdcidade());
			sta.setInt(8, cliente.getIdCliente());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();	
	}
	public void excluir(Cliente cliente) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM cliente "
					+ "WHERE idcliente = ?";
			PreparedStatement sta = con.getConexao().prepareStatement(sql);
			sta.setInt(1, cliente.getIdCliente());
			sta.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
     }

}