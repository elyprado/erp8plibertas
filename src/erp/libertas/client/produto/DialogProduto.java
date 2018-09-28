package erp.libertas.client.produto;

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
import erp.libertas.shared.Fornecedor;
import erp.libertas.shared.Produto;

public class DialogProduto extends DialogBox {
	private CaixaDeTexto txtDescricao = new CaixaDeTexto("Descricao:");
	private CaixaDeTexto txtMarca = new CaixaDeTexto("Marca:");
	private CaixaDeTexto txtPreco = new CaixaDeTexto("Preco:");
	private CaixaDeTexto txtSaldoEstoque = new CaixaDeTexto("Saldo em estoque:");
	private CaixaDeTexto txtCodBarras = new CaixaDeTexto("Código de barras:");
	
	private Button btnSalvar = new Button("Salvar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnCancelar = new Button("Cancelar");
	
	private HorizontalPanel painelBtn = new HorizontalPanel();
	private VerticalPanel painel = new VerticalPanel();
	private Produto produto;
	private final GreetingServiceAsync service = GWT.create(GreetingService.class);
	private ListaProduto listaProduto;
	
	public DialogProduto(ListaProduto listaProduto, Fornecedor f) {
		this.produto = f;
		this.listaProduto = listaProduto;
		
		painel.add(txtDescricao);
		painel.add(txtMarca);
		painel.add(txtPreco);
		painel.add(txtSaldoEstoque);
		painel.add(txtCodBarras);
		painel.add(painelBtn);
		
		painelBtn.add(btnSalvar);
		painelBtn.add(btnExcluir);
		painelBtn.add(btnCancelar);
		
		super.add(painel);
		super.setText("Cadastro de Produto");
		
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
		produto.setDescricao(txtDescricao.getText());
		produto.setMarca(txtMarca.getText());
		produto.setPreco(Double.parseDouble(txtPreco.getText()));
		produto.setSaldoEstoque(Integer.parseInt(txtSaldoEstoque.getText()));
		produto.setCodBarras(txtCodBarras.getText());
		
		service.inserirProduto(produto, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Registro inserido com sucesso");
				hide();
				listaProduto.listar();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Falha ao comunicar com servidor");
			}
		});
	}
}

