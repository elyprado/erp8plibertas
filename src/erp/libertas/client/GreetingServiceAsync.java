package erp.libertas.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import erp.libertas.shared.Cliente;
import erp.libertas.shared.Fornecedor;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void listarFornecedor(AsyncCallback<List<Fornecedor>> callback);
	void inserirFornecedor(Fornecedor f, AsyncCallback<Void> callback);
	void alterarFornecedor(Fornecedor f, AsyncCallback<Void> callback);
	void excluirFornecedor(Fornecedor f, AsyncCallback<Void> callback);
	void listarCliente(AsyncCallback<List<Cliente>> callback);
	void inserirCliente(Cliente c, AsyncCallback<Void> callback);
	void alterarCliente(Cliente c, AsyncCallback<Void> callback);
	void excluirCliente(Cliente c, AsyncCallback<Void> callback);
	
}
