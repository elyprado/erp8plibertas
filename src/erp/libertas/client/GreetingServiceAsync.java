package erp.libertas.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import erp.libertas.shared.Banco;
import erp.libertas.shared.Caixa;
import erp.libertas.shared.Cidade;
import erp.libertas.shared.Cliente;
import erp.libertas.shared.Compra;
import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Pagar;
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

	void listarCliente(AsyncCallback<List<Cliente>> callback);
	void inserirCliente(Cliente c, AsyncCallback<Void> callback);
	void alterarCliente(Cliente c, AsyncCallback<Void> callback);
	void excluirCliente(Cliente c, AsyncCallback<Void> callback);
	

	void listarProduto(AsyncCallback<List<Produto>> callback);
	void alterarProduto(Produto p, AsyncCallback<Void> callback);
	void excluirProduto(Produto p, AsyncCallback<Void> callback);
	void inserirProduto(Produto p, AsyncCallback<Void> callback);
	void alterarReceber(Receber r, AsyncCallback<Void> callback);
	void excluirReceber(Receber r, AsyncCallback<Void> callback);
	void inserirReceber(Receber r, AsyncCallback<Void> callback);
	void listaReceber(AsyncCallback<List<Receber>> asyncCallback);
	void listarBanco(AsyncCallback<List<Banco>> callback);
	void inserirBanco(Banco b, AsyncCallback<Void> callback);
	void alterarBanco(Banco b, AsyncCallback<Void> callback);
	void excluirBanco(Banco b, AsyncCallback<Void> callback);
	void listarCaixa(AsyncCallback<List<Caixa>> callback);
	void inserirCaixa(Caixa c, AsyncCallback<Void> callback);
	void alterarCaixa(Caixa c, AsyncCallback<Void> callback);
	void excluirCaixa(Caixa c, AsyncCallback<Void> callback);

	void listarPagar(AsyncCallback<List<Pagar>> callback);
	void inserirPagar(Pagar pa, AsyncCallback<Void> callback);
	void alterarPagar(Pagar pa, AsyncCallback<Void> callback);
	void excluirPagar(Pagar pa, AsyncCallback<Void> callback);
	
	void listarCompra(AsyncCallback<List<Compra>> callback);
	void inserirCompra(Compra c, AsyncCallback<Void> callback);
	void alterarCompra(Compra c, AsyncCallback<Void> callback);
	void excluirCompra(Compra c, AsyncCallback<Void> callback);
	void listarCidade(AsyncCallback<ArrayList<Cidade>> callback);
}
