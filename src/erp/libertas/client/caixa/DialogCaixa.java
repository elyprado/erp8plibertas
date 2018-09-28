package erp.libertas.client.caixa;

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
import erp.libertas.client.caixa.ListaCaixa;
import erp.libertas.shared.Caixa;
import erp.libertas.shared.Banco;

public class DialogCaixa extends DialogBox{

    private CaixaDeTexto txtData = new CaixaDeTexto("Data:");
    private CaixaDeTexto txtValor = new CaixaDeTexto("Valor:");
    private CaixaDeTexto txtDescricao = new CaixaDeTexto("Descricao:");
    private CaixaDeTexto txtPlanoDeContas = new CaixaDeTexto("Plano de Contas:");
    private CaixaDeTexto txtBanco = new CaixaDeTexto("Banco:");
	
    private Button btnSalvar = new Button("Salvar");
    private Button btnExcluir = new Button("Excluir");
    private Button btnCancelar = new Button("Cancelar");
	
    private HorizontalPanel painelBtn = new HorizontalPanel();
    private VerticalPanel painel = new VerticalPanel();
    private Caixa caixa;
    private final GreetingServiceAsync service = GWT.create(GreetingService.class);
    private ListaCaixa listaCaixa;
	
    public DialogCaixa(ListaCaixa listaCaixa, Caixa caixa) {
	this.caixa = caixa;
	this.listaCaixa = listaCaixa;
	
	painel.add(txtData);
	painel.add(txtValor);
	painel.add(txtDescricao);
	painel.add(txtPlanoDeContas);
	painel.add(txtBanco);
	painel.add(painelBtn);
	
	painelBtn.add(btnSalvar);
	painelBtn.add(btnExcluir);
	painelBtn.add(btnCancelar);
	
	super.add(painel);
	super.setText("Cadastro de Caixa");
	
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
	Banco b = new Banco();
	b.setIdBanco(Integer.parseInt(txtBanco.getText()));
	caixa.setBanco(b);
	//caixa.setData(txtData.getText());
	caixa.setValor(Double.parseDouble(txtValor.getText()));
	caixa.setDescricao(txtDescricao.getText());
	caixa.setPlanoDeContas(txtPlanoDeContas.getText());
	
	service.inserirCaixa(caixa, new AsyncCallback<Void>() {
		
		@Override
		public void onSuccess(Void result) {
			Window.alert("Registro inserido com sucesso");
			hide();
			listaCaixa.listar();
		}
		
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Falha ao comunicar com servidor");
		}
	});
    }

}
