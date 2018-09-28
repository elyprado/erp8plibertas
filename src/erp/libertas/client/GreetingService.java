package erp.libertas.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

<<<<<<< HEAD
import erp.libertas.shared.Cliente;
=======
import erp.libertas.shared.Banco;
import erp.libertas.shared.Caixa;
>>>>>>> branch 'master' of https://github.com/elyprado/erp8plibertas.git
import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Produto;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	public List<Fornecedor> listarFornecedor();
	public void inserirFornecedor(Fornecedor f);
	public void alterarFornecedor(Fornecedor f);
	public void excluirFornecedor(Fornecedor f);
<<<<<<< HEAD
	public List<Cliente> listarCliente();
	public void inserirCliente(Cliente c);
	public void alterarCliente(Cliente c);
	public void excluirCliente(Cliente c);
	
=======
	
	public List<Produto> listarProduto();
	public void inserirProduto(Produto p);
	public void alterarProduto(Produto p);
	public void excluirProduto(Produto p);
	
	List<Banco> listarBanco();
	void inserirBanco(Banco b);
	void alterarBanco(Banco b);
	void excluirBanco(Banco b);
	
	List<Caixa> listarCaixa();
	void inserirCaixa(Caixa c);
	void alterarCaixa(Caixa c);
	void excluirCaixa(Caixa c);
>>>>>>> branch 'master' of https://github.com/elyprado/erp8plibertas.git
	
}
