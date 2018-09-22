package erp.libertas.client.pagar;

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
import erp.libertas.shared.Cidade;
import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Pagar;

public class DialogPagar extends DialogBox {
	private CaixaDeTexto txtDataLancto = new CaixaDeTexto("Data de Lancamento:");
	private CaixaDeTexto txtDataVencimento = new CaixaDeTexto("Data de Vencimento:");
	private CaixaDeTexto txtFornecedor = new CaixaDeTexto("Fornecedor:");
	private CaixaDeTexto txtValor = new CaixaDeTexto("Valor:");
	private CaixaDeTexto txtValorPago = new CaixaDeTexto("Valor Pago:");
	private CaixaDeTexto txtDataPagamento = new CaixaDeTexto("Data Pagamento:");
	private CaixaDeTexto txtDescricao = new CaixaDeTexto("Descricao:");
	private Button btnSalvar = new Button("Salvar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnCancelar = new Button("Cancelar");
	private HorizontalPanel painelBtn = new HorizontalPanel();
	private VerticalPanel painel = new VerticalPanel();
	private Pagar pagar;
	private final GreetingServiceAsync service = GWT.create(GreetingService.class);
	private ListaPagar listapagar;
	
	public DialogPagar(ListaPagar listaPagar, Pagar pagar) {
		this.pagar = pagar;
		this.listapagar = listapagar;
		
		painel.add(txtDataLancto);
		painel.add(txtDataVencimento);
		painel.add(txtFornecedor);
		painel.add(txtValor);
		painel.add(txtValorPago);
		painel.add(txtDataPagamento);
		painel.add(txtDescricao);
		painel.add(painelBtn);
		
		painelBtn.add(btnSalvar);
		painelBtn.add(btnExcluir);
		painelBtn.add(btnCancelar);
		
		super.add(painel);
		super.setText("Contas a Pagar");
		
		btnSalvar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//salvar();
			}
		});
		btnCancelar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
	}
/*
	private void salvar() {
		Fornecedor f= new Fornecedor();
		f.setIdfornecedor(Integer.parseInt(txtFornecedor.getText()));
		pagar.setFornecedor(f);
		pagar.setDataLancto(txtDataLancto.getText());
		pagar.setDataVencimento(txtDataVencimento.getText());
		pagar.setNome(txtNome.getText());
		pagar.setTelefone(txtTelefone.getText());
		
		service.inserirpagar(pagar, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Registro inserido com sucesso");
				hide();
				listapagar.listar();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Falha ao comunicar com servidor");
			}
		});
	}*/
}
