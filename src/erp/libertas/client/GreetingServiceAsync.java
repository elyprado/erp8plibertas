package erp.libertas.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Produto;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void listarFornecedor(AsyncCallback<List<Fornecedor>> callback);
	void inserirFornecedor(Fornecedor f, AsyncCallback<Void> callback);
	void alterarFornecedor(Fornecedor f, AsyncCallback<Void> callback);
	void excluirFornecedor(Fornecedor f, AsyncCallback<Void> callback);
	void listarProduto(AsyncCallback<List<Produto>> callback);
	void alterarProduto(Produto p, AsyncCallback<Void> callback);
	void excluirProduto(Produto p, AsyncCallback<Void> callback);
	void inserirProduto(Produto p, AsyncCallback<Void> callback);
}
