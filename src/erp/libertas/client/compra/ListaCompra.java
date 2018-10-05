package erp.libertas.client.compra;

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
import erp.libertas.shared.Compra;
import erp.libertas.shared.Fornecedor;

public class ListaCompra extends Composite {
	private VerticalPanel painel = new VerticalPanel();
	private Button btnNovo = new Button("Nova Compra");
	private final GreetingServiceAsync service = GWT.create(GreetingService.class);
	private Label lblTitulo = new Label("Cadastro de Compras");
	
	public ListaCompra() {
		initWidget(painel);
		listar();
		
		btnNovo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Compra c = new Compra();
				DialogCompra dialog = new DialogCompra(ListaCompra.this, c);
				dialog.center();
			}
		});
	}
	public void listar() {
		painel.clear();
		painel.add(lblTitulo);
		painel.add(new Label("Aguarde, carregando..."));

		
		service.listarCompra(new AsyncCallback<List<Compra>>() {
			@Override
			public void onSuccess(List<Compra> result) {
				painel.clear();
				painel.add(lblTitulo);
				painel.add(btnNovo);
				for (Compra c : result) {
					ItemCompra item = new ItemCompra(ListaCompra.this, c);
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
