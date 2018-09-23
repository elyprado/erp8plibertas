package erp.libertas.client;

import erp.libertas.client.banco.ListaBanco;
import erp.libertas.client.caixa.ListaCaixa;
import erp.libertas.client.fornecedor.ListaFornecedor;
import erp.libertas.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class ERP8pLibertas implements EntryPoint {
	private HorizontalPanel painelMenu = new HorizontalPanel();
	private VerticalPanel painelConteudo = new VerticalPanel();
	private Label lblTitulo = new Label("ERP 8o período - Libertas");
	private Button btnFornecedor = new Button("Cadastro de Fornecedores");
	private Button btnBanco = new Button("Cadastro de Banco");
	private Button btnCaixa = new Button("Cadastro de Caixa");
	
	public void onModuleLoad() {
		RootPanel.get().add(lblTitulo);
		RootPanel.get().add(painelMenu);
		RootPanel.get().add(painelConteudo);

		painelMenu.add(btnFornecedor);
		btnFornecedor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListaFornecedor cad = new ListaFornecedor();
				painelConteudo.clear();
				painelConteudo.add(cad);
			}
		});
		
		painelMenu.add(btnBanco);
		btnBanco.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListaBanco cadBanco = new ListaBanco();
				painelConteudo.clear();
				painelConteudo.add(cadBanco);
			}
		});
		
		painelMenu.add(btnCaixa);
		btnCaixa.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListaCaixa cadCaixa = new ListaCaixa();
				painelConteudo.clear();
				painelConteudo.add(cadCaixa);
			}
		});
	}
}
