package erp.libertas.client.caixa;

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
import erp.libertas.client.caixa.DialogCaixa;
import erp.libertas.client.caixa.ItemCaixa;
import erp.libertas.client.caixa.ListaCaixa;
import erp.libertas.shared.Caixa;

public class ListaCaixa extends Composite {
    
	private VerticalPanel painel = new VerticalPanel();
	private Button btnNovo = new Button("Novo Caixa");
	private final GreetingServiceAsync service = GWT.create(GreetingService.class);
	private Label lblTitulo = new Label("Cadastro de Caixa");
	
	public ListaCaixa() {
		initWidget(painel);
		listar();
		
		btnNovo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				Caixa c = new Caixa();
				DialogCaixa dialog = new DialogCaixa(ListaCaixa.this, c);
				dialog.center();
			}
		});
	}
	public void listar() {
		painel.clear();
		painel.add(lblTitulo);
		painel.add(new Label("Aguarde, carregando..."));

		
		service.listarCaixa(new AsyncCallback<List<Caixa>>() {
			@Override
			public void onSuccess(List<Caixa> result) {
				painel.clear();
				painel.add(lblTitulo);
				painel.add(btnNovo);
				for (Caixa c : result) {
					ItemCaixa item = new ItemCaixa(ListaCaixa.this, c);
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
