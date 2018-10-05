package erp.libertas.client.fornecedor;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import erp.libertas.client.GreetingService;
import erp.libertas.client.GreetingServiceAsync;
import erp.libertas.client.componente.CaixaDeTexto;
import erp.libertas.shared.Cidade;
import erp.libertas.shared.Fornecedor;

public class DialogFornecedor extends DialogBox {
	private CaixaDeTexto txtNome = new CaixaDeTexto("Nome:");
	private CaixaDeTexto txtEndereco = new CaixaDeTexto("Endereco:");
	private ListBox lstCidade = new ListBox();
	private Label lblCidade = new Label("Cidade:");
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
		painel.add(lblCidade);
		painel.add(lstCidade);
		painel.add(txtTelefone);
		painel.add(painelBtn);
		
		painelBtn.add(btnSalvar);
		painelBtn.add(btnExcluir);
		painelBtn.add(btnCancelar);
		
		listarCidades();
		
		if (fornecedor.getIdfornecedor()>0) {
			txtNome.setText(fornecedor.getNome());
			txtEndereco.setText(fornecedor.getEndereco());
			txtTelefone.setText(fornecedor.getTelefone());
		}
		
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
		btnExcluir.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				excluir();
			}
		});
	}
	
	

	private void salvar() {
		Cidade c = new Cidade();
		c.setIdcidade( Integer.parseInt(lstCidade.getSelectedValue()));
		fornecedor.setCidade(c);
		fornecedor.setEndereco(txtEndereco.getText());
		fornecedor.setNome(txtNome.getText());
		fornecedor.setTelefone(txtTelefone.getText());
		
		if (fornecedor.getIdfornecedor()>0) {
			//alterar
			service.alterarFornecedor(fornecedor, new AsyncCallback<Void>() {
				
				@Override
				public void onSuccess(Void result) {
					Window.alert("Registro alterado com sucesso");
					hide();
					listaFornecedor.listar();
				}
				
				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Falha ao comunicar com servidor");
				}
			});
		}else {
			//inserir
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
	
	public void excluir() {
		service.excluirFornecedor(fornecedor, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("registro excluido!");
				hide();
				listaFornecedor.listar();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Falha ao excluir o registro");
			}
		});
	}
	
	private void listarCidades() {
		lstCidade.clear();
		lstCidade.addItem("Aguarde, carregando...");
		
		service.listarCidade(new AsyncCallback<ArrayList<Cidade>>() {
			
			@Override
			public void onSuccess(ArrayList<Cidade> result) {
				lstCidade.clear();
				int index = 0;
				for (Cidade cidade : result) {
					lstCidade.addItem(cidade.getNome(), String.valueOf(cidade.getIdcidade()) );
					if (fornecedor.getCidade()!=null) {
						if (cidade.getIdcidade()==fornecedor.getCidade().getIdcidade()) {
							lstCidade.setSelectedIndex(index);
						}
					}
					index++;
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Erro ao comunicar com o servidor");
			}
		});
	}
}














