package erp.libertas.client.pagar;

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
import erp.libertas.shared.Pagar;


public class ListaPagar extends Composite {
	private VerticalPanel painel = new VerticalPanel();
	private Button btnNovo = new Button("Novo Contas a Pagar");
	private final GreetingServiceAsync service = GWT.create(GreetingService.class);
	private Label lblTitulo = new Label("Cadastro de Contas a Pagar");
	
	public ListaPagar() {
		initWidget(painel);
		listar();
		
		btnNovo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Pagar p = new Pagar();
				DialogPagar dialog = new DialogPagar(ListaPagar.this, p);
				dialog.center();
			}
		});
	}
	public void listar() {
		painel.clear();
		painel.add(lblTitulo);
		painel.add(new Label("Aguarde, carregando..."));

		
		service.listarPagar(new AsyncCallback<List<Pagar>>() {
			@Override
			public void onSuccess(List<Pagar> result) {
				painel.clear();
				painel.add(lblTitulo);
				painel.add(btnNovo);
				for (Pagar p : result) {
					ItemPagar item = new ItemPagar(ListaPagar.this, p);
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

