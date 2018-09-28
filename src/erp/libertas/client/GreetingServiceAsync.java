package erp.libertas.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import erp.libertas.shared.Banco;
import erp.libertas.shared.Caixa;
import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Produto;
import erp.libertas.shared.Receber;

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
<<<<<<< HEAD
	void alterarReceber(Receber r, AsyncCallback<Void> callback);
	void excluirReceber(Receber r, AsyncCallback<Void> callback);
	void inserirReceber(Receber r, AsyncCallback<Void> callback);
	void listaReceber(AsyncCallback<List<Receber>> asyncCallback);
=======
	void listarBanco(AsyncCallback<List<Banco>> callback);
	void inserirBanco(Banco b, AsyncCallback<Void> callback);
	void alterarBanco(Banco b, AsyncCallback<Void> callback);
	void excluirBanco(Banco b, AsyncCallback<Void> callback);
	void listarCaixa(AsyncCallback<List<Caixa>> callback);
	void inserirCaixa(Caixa c, AsyncCallback<Void> callback);
	void alterarCaixa(Caixa c, AsyncCallback<Void> callback);
	void excluirCaixa(Caixa c, AsyncCallback<Void> callback);
>>>>>>> branch 'master' of https://github.com/elyprado/erp8plibertas.git
}
