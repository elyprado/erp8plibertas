package erp.libertas.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Produto;
import erp.libertas.shared.Receber;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	public List<Fornecedor> listarFornecedor();
	public void inserirFornecedor(Fornecedor f);
	public void alterarFornecedor(Fornecedor f);
	public void excluirFornecedor(Fornecedor f);
	
	public List<Produto> listarProduto();
	public void inserirProduto(Produto p);
	public void alterarProduto(Produto p);
	public void excluirProduto(Produto p);
	void alterarReceber(Receber r);
	void excluirReceber(Receber r);
	void inserirReceber(Receber r);
	List<Receber> listaReceber();
	
}
