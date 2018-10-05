package erp.libertas.client.compra;

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
import erp.libertas.shared.Compra;
import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Produto;

public class DialogCompra extends DialogBox{
	private CaixaDeTexto txtFornecedor = new CaixaDeTexto("Fornecedor:");
	private CaixaDeTexto txtqtd = new CaixaDeTexto("Quantidade:");
	private CaixaDeTexto txtUnitario = new CaixaDeTexto("Valor Unitário:");
	private CaixaDeTexto txtTotal = new CaixaDeTexto("Valor Total:");
	private CaixaDeTexto txtNumNota = new CaixaDeTexto("Número da nota fiscal:");
	private CaixaDeTexto txtDataCompra = new CaixaDeTexto("Data da Compra:");
	private CaixaDeTexto txtProduto = new CaixaDeTexto("Produto:");
	private Button btnSalvar = new Button("Salvar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnCancelar = new Button("Cancelar");
	private HorizontalPanel painelBtn = new HorizontalPanel();
	private VerticalPanel painel = new VerticalPanel();
	private Compra compra;
	private final GreetingServiceAsync service = GWT.create(GreetingService.class);
	private ListaCompra listaCompra;
	
	public DialogCompra(ListaCompra listaCompra, Compra compra) {
		this.compra = compra;
		this.listaCompra = listaCompra;
		
		painel.add(txtNumNota);
		painel.add(txtFornecedor);
		painel.add(txtqtd);
		painel.add(txtUnitario);
		painel.add(txtTotal);
		painel.add(txtDataCompra);
		painel.add(txtProduto);
		painel.add(painelBtn);
		
		painelBtn.add(btnSalvar);
		painelBtn.add(btnExcluir);
		painelBtn.add(btnCancelar);
		
		super.add(painel);
		super.setText("Cadastro de Compras");
		
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
		Fornecedor f = new Fornecedor();
		f.setIdfornecedor(Integer.parseInt(txtFornecedor.getText()));
		Produto p = new Produto();
		p.setIdProduto(Integer.parseInt(txtProduto.getText()));
		compra.setData(txtDataCompra.getText());
		compra.setNumNotaFiscal(Integer.parseInt(txtNumNota.getText()));
		compra.setValorTotal(Double.parseDouble(txtTotal.getText()));
		compra.setValorUnitario(Double.parseDouble(txtUnitario.getText()));
		compra.setQtd(Integer.parseInt(txtqtd.getText()));
		compra.setFornecedor(f);
		compra.setProduto(p);
		service.inserirCompra(compra , new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Registro inserido com sucesso");
				hide();
				listaCompra.listar();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Falha ao comunicar com servidor");
			}
		});
	}
}
