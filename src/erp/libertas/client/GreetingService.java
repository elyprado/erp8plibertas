package erp.libertas.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import erp.libertas.shared.Cliente;
import erp.libertas.shared.Fornecedor;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	public List<Fornecedor> listarFornecedor();
	public void inserirFornecedor(Fornecedor f);
	public void alterarFornecedor(Fornecedor f);
	public void excluirFornecedor(Fornecedor f);
	public List<Cliente> listarCliente();
	public void inserirCliente(Cliente c);
	public void alterarCliente(Cliente c);
	public void excluirCliente(Cliente c);
	
	
}
