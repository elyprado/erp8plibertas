package erp.libertas.server;

import erp.libertas.client.GreetingService;
import erp.libertas.server.dao.ClienteDao;
import erp.libertas.server.dao.FornecedorDao;
import erp.libertas.shared.Cliente;
import erp.libertas.server.dao.ProdutoDao;
import erp.libertas.server.dao.BancoDao;
import erp.libertas.server.dao.CaixaDao;
import erp.libertas.shared.FieldVerifier;
import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Produto;
import erp.libertas.shared.Receber;
import erp.libertas.shared.Banco;
import erp.libertas.shared.Caixa;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	@Override
	public List<Fornecedor> listarFornecedor() {
		FornecedorDao fdao = new FornecedorDao();
		return fdao.listar();
	}

	@Override
	public void inserirFornecedor(Fornecedor f) {
		FornecedorDao fdao = new FornecedorDao();
		fdao.inserir(f);
	}

	@Override
	public void alterarFornecedor(Fornecedor f) {
		FornecedorDao fdao = new FornecedorDao();
		fdao.alterar(f);	
	}

	@Override
	public void excluirFornecedor(Fornecedor f) {
		FornecedorDao fdao = new FornecedorDao();
		fdao.excluir(f);
	}
	@Override
	public List<Cliente> listarCliente() {
		ClienteDao cdao = new ClienteDao();
		return cdao.listar();
	}

	@Override
	public void inserirCliente(Cliente c) {
		ClienteDao cdao = new ClienteDao();
		cdao.inserir(c);
	}

	@Override
	public void alterarCliente(Cliente c) {
		ClienteDao cdao = new ClienteDao();
		cdao.alterar(c);	
	}

	@Override
	public void excluirCliente(Cliente c) {
		ClienteDao cdao = new ClienteDao();
		cdao.excluir(c);

	@Override
	public List<Produto> listarProduto() {
		ProdutoDao pdao = new ProdutoDao();
		return pdao.listar();
	}

	@Override
	public void inserirProduto(Produto p) {
		ProdutoDao pdao = new ProdutoDao();
		pdao.inserir(p);
		
	}

	@Override
	public void alterarProduto(Produto p) {
		ProdutoDao pdao = new ProdutoDao();
		pdao.alterar(p);
		
	}

	@Override
	public void excluirProduto(Produto p) {
		ProdutoDao pdao = new ProdutoDao();
		pdao.excluir(p);
		
	}
	
	@Override
	public List<Banco> listarBanco() {
		BancoDao bdao = new BancoDao();
		return bdao.listar();
	}

	@Override
	public void inserirBanco(Banco b) {
		BancoDao bdao = new BancoDao();
		bdao.inserir(b);
		
	}

	@Override
	public void alterarBanco(Banco b) {
		BancoDao bdao = new BancoDao();
		bdao.alterar(b);
		
	}

	@Override
	public void excluirBanco(Banco b) {
		BancoDao bdao = new BancoDao();
		bdao.excluir(b);
		
	}
	
	@Override
	public List<Caixa> listarCaixa() {
		CaixaDao cdao = new CaixaDao();
		return cdao.listar();
	}

	@Override
	public void inserirCaixa(Caixa c) {
		CaixaDao cdao = new CaixaDao();
		cdao.inserir(c);
		
	}

	@Override
	public void alterarCaixa(Caixa c) {
		CaixaDao cdao = new CaixaDao();
		cdao.alterar(c);
		
	}

	@Override
	public void excluirCaixa(Caixa c) {
		CaixaDao cdao = new CaixaDao();
		cdao.excluir(c);
	}
}
