2package erp.libertas.client.Receber;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import erp.libertas.client.GreetingService;
import erp.libertas.client.GreetingServiceAsync;
import erp.libertas.shared.Fornecedor;

public class ListaReceber extends Composite {
	private VerticalPanel painel = new VerticalPanel();
	private Button btnNovo = new Button("Novo Fornecedor");
	private final GreetingServiceAsync service = GWT.create(GreetingService.class);
	private Label lblTitulo = new Label("Cadastro de Fornecedores");
	
	public ListaReceber() {
		initWidget(painel);
		listar();
		
		btnNovo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Fornecedor f = new Fornecedor();
				DialogReceber dialog = new DialogReceber(ListaFornecedor.this, f);
				dialog.center();
			}
		});
	}
	public void listar() {
		painel.clear();
		painel.add(lblTitulo);
		painel.add(new Label("Aguarde, carregando..."));

		
		service.listarFornecedor(new AsyncCallback<List<Fornecedor>>() {
			@Override
			public void onSuccess(List<Fornecedor> result) {
				painel.clear();
				painel.add(lblTitulo);
				painel.add(btnNovo);
				for (Fornecedor f : result) {
					ItemFornecedor item = new ItemFornecedor(ListaFornecedor.this, f);
					painel.add(item);
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Falha ao comunicar com servidor");
			}
		});
	}
}
