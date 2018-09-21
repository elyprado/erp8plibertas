package erp.libertas.server;

import erp.libertas.client.GreetingService;
import erp.libertas.server.dao.FornecedorDao;
import erp.libertas.shared.FieldVerifier;
import erp.libertas.shared.Fornecedor;

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
}
