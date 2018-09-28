package erp.libertas.client.banco;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import erp.libertas.client.GreetingService;
import erp.libertas.client.GreetingServiceAsync;
import erp.libertas.client.componente.CaixaDeTexto;
import erp.libertas.shared.Banco;

public class DialogBanco extends DialogBox {

    private CaixaDeTexto txtNome = new CaixaDeTexto("Nome:");
    private Button btnSalvar = new Button("Salvar");
    private Button btnExcluir = new Button("Excluir");
    private Button btnCancelar = new Button("Cancelar");
    private HorizontalPanel painelBtn = new HorizontalPanel();
    private VerticalPanel painel = new VerticalPanel();
    private Banco banco;
    private final GreetingServiceAsync service = GWT.create(GreetingService.class);
    private ListaBanco listaBanco;
	
    public DialogBanco(ListaBanco listaBanco, Banco banco) {
	this.banco = banco;
	this.listaBanco = listaBanco;
	
	painel.add(txtNome);
	painel.add(painelBtn);
	
	painelBtn.add(btnSalvar);
	painelBtn.add(btnExcluir);
	painelBtn.add(btnCancelar);
		
	super.add(painel);
	super.setText("Cadastro de Banco");
	
	btnSalvar.addClickHandler(new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			salvar();
		}
	});
	btnCancelar.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			hide();
		}
	});
    }

    private void salvar() {
	
	banco.setNome(txtNome.getText());
	
	service.inserirBanco(banco, new AsyncCallback<Void>() {
		
		@Override
		public void onSuccess(Void result) {
			Window.alert("Registro inserido com sucesso");
			hide();
			listaBanco.listar();
		}
		
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Falha ao comunicar com servidor");
		}
	});
    }

}
