package erp.libertas.client.banco;

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
import erp.libertas.shared.Banco;

public class ListaBanco extends Composite{

    private VerticalPanel painel = new VerticalPanel();
    private Button btnNovo = new Button("Novo Banco");
    private final GreetingServiceAsync service = GWT.create(GreetingService.class);
    private Label lblTitulo = new Label("Cadastro de Banco");
	
    public ListaBanco() {
	initWidget(painel);
	listar();
		
	btnNovo.addClickHandler(new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			Banco f = new Banco();
			DialogBanco dialog = new DialogBanco(ListaBanco.this, f);
			dialog.center();
		}
	});
    }
	
    public void listar() {
	
	painel.clear();
	painel.add(lblTitulo);
	painel.add(new Label("Aguarde, carregando..."));
		
	service.listarBanco(new AsyncCallback<List<Banco>>() {
		@Override
		public void onSuccess(List<Banco> result) {
			painel.clear();
			painel.add(lblTitulo);
			painel.add(btnNovo);
			for (Banco b : result) {
				ItemBanco item = new ItemBanco(ListaBanco.this, b);
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
