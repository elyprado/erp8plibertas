package erp.libertas.client.Receber;

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
import erp.libertas.shared.Receber;

public class DialogReceber extends DialogBox {
private CaixaDeTexto txtdataLancto= new CaixaDeTexto("Data Lançamento:");
private CaixaDeTexto txtdataVencimento= new CaixaDeTexto("Data Vencimento:");
private CaixaDeTexto txtcliente= new CaixaDeTexto("Cliente:");
private CaixaDeTexto txtvalor= new CaixaDeTexto("Valor:");
private CaixaDeTexto txtvalorPago= new CaixaDeTexto("Valor Pago:");
private CaixaDeTexto txtdataPagamento= new CaixaDeTexto("Data Pagamento:");
private CaixaDeTexto txtdescricao= new CaixaDeTexto("Descricao:");
private Button btnSalvar = new Button("Salvar");
private Button btnExcluir = new Button("Excluir");
private Button btnCancelar = new Button("Cancelar");
	private HorizontalPanel painelBtn = new HorizontalPanel();
	private VerticalPanel painel = new VerticalPanel();
	private erp.libertas.shared.Receber Receber;
	private final GreetingServiceAsync service = GWT.create(GreetingService.class);
	private ListaReceber listaReceber;
	
	public DialogReceber(ListaReceber listaReceber, Receber Receber) {
		this.Receber = Receber;
		this.listaReceber = listaReceber;
		
		painel.add(  txtdataLancto);
		painel.add(  txtdataVencimento);
		painel.add(  txtcliente);
		painel.add(  txtvalor);
		painel.add(  txtvalorPago);
		painel.add(             txtdataPagamento);
		painel.add(txtdescricao);
		painelBtn.add(btnSalvar);		
		painelBtn.add(btnExcluir);
		painelBtn.add(btnCancelar);
		
		super.add(painel);
		super.setText("Cadastro de Contas a Receber");
		
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
		Cliente c = new Cliente();
		c.setIdCliente( Integer.parseInt(txtcliente.getText()));
		Receber.setCliente(txtcliente.getText());
		Receber.setDataLancto(txtdataLancto.getText());
		Receber.setDataPagamento(txtdataPagamento.getText());
		Receber.setDataVencimento(txtdataVencimento.getText());
		Receber.setDescricao(txtdescricao.getText());
		Receber.setValor(Double.parseDouble(txtvalor.getText()));
		Receber.setValorPago(Double.parseDouble(txtvalorPago.getText()));
		service.inserirReceber(Receber, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Registro inserido com sucesso");
				hide();
				listaReceber.listar();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Falha ao comunicar com servidor");
			}
		});
	}
}
