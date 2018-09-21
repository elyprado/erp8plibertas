package erp.libertas.client.fornecedor;

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

public class DialogFornecedor extends DialogBox {
	private CaixaDeTexto txtNome = new CaixaDeTexto("Nome:");
	private CaixaDeTexto txtEndereco = new CaixaDeTexto("Endereco:");
	private CaixaDeTexto txtCidade = new CaixaDeTexto("Cidade:");
	private CaixaDeTexto txtTelefone = new CaixaDeTexto("Telefone:");
	private Button btnSalvar = new Button("Salvar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnCancelar = new Button("Cancelar");
	private HorizontalPanel painelBtn = new HorizontalPanel();
	private VerticalPanel painel = new VerticalPanel();
	private Fornecedor fornecedor;
	private final GreetingServiceAsync service = GWT.create(GreetingService.class);
	private ListaFornecedor listaFornecedor;
	
	public DialogFornecedor(ListaFornecedor listaFornecedor, Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		this.listaFornecedor = listaFornecedor;
		
		painel.add(txtNome);
		painel.add(txtEndereco);
		painel.add(txtCidade);
		painel.add(txtTelefone);
		painel.add(painelBtn);
		
		painelBtn.add(btnSalvar);
		painelBtn.add(btnExcluir);
		painelBtn.add(btnCancelar);
		
		super.add(painel);
		super.setText("Cadastro de Fornecedor");
		
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
		Cidade c = new Cidade();
		c.setIdcidade( Integer.parseInt(txtCidade.getText()));
		fornecedor.setCidade(c);
		fornecedor.setEndereco(txtEndereco.getText());
		fornecedor.setNome(txtNome.getText());
		fornecedor.setTelefone(txtTelefone.getText());
		
		service.inserirFornecedor(fornecedor, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Registro inserido com sucesso");
				hide();
				listaFornecedor.listar();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Falha ao comunicar com servidor");
			}
		});
	}
}
