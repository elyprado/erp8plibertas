package erp.libertas.client.cliente;

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
import erp.libertas.client.cliente.DialogCliente;
import erp.libertas.client.cliente.ItemCliente;
import erp.libertas.client.cliente.ListaCliente;
import erp.libertas.shared.Cliente;

public class ListaCliente extends Composite {
	private VerticalPanel painel = new VerticalPanel();
	private Button btnNovo = new Button("Novo Cliente");
	private final GreetingServiceAsync service = GWT.create(GreetingService.class);
	private Label lblTitulo = new Label("Cadastro de Cliente");

	public ListaCliente() {
		initWidget(painel);
		listar();

		btnNovo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Cliente c = new Cliente();
				DialogCliente dialog = new DialogCliente(ListaCliente.this, c);
				dialog.center();
			}
		});
	}

	public void listar() {
		painel.clear();
		painel.add(lblTitulo);
		painel.add(new Label("Aguarde, carregando..."));

		service.listarCliente(new AsyncCallback<List<Cliente>>() {
			@Override
			public void onSuccess(List<Cliente> result) {
				painel.clear();
				painel.add(lblTitulo);
				painel.add(btnNovo);
				for (Cliente c : result) {
					ItemCliente item = new ItemCliente(ListaCliente.this, c);
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
