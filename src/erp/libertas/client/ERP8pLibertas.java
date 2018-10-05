package erp.libertas.client;

import erp.libertas.client.Receber.ListaReceber;

import erp.libertas.client.cliente.ListaCliente;
import erp.libertas.client.banco.ListaBanco;
import erp.libertas.client.caixa.ListaCaixa;
import erp.libertas.client.fornecedor.ListaFornecedor;
import erp.libertas.client.pagar.ListaPagar;
import erp.libertas.client.produto.ListaProduto;
import erp.libertas.shared.FieldVerifier;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import erp.libertas.client.Receber.ListaReceber;
import erp.libertas.client.banco.ListaBanco;
import erp.libertas.client.caixa.ListaCaixa;
import erp.libertas.client.cliente.ListaCliente;
import erp.libertas.client.compra.ListaCompra;
import erp.libertas.client.fornecedor.ListaFornecedor;
import erp.libertas.client.produto.ListaProduto;


public class ERP8pLibertas implements EntryPoint {
	private HorizontalPanel painelMenu = new HorizontalPanel();
	private VerticalPanel painelConteudo = new VerticalPanel();
	private Label lblTitulo = new Label("ERP 8o período - Libertas");
	private Button btnFornecedor = new Button("Cadastro de Fornecedores");

	private Button btnCliente = new Button("Cadastro de Clientes");

	private Button btnBanco = new Button("Cadastro de Banco");
	private Button btnReceber = new Button("Cadastro de Contas a Receber");
	private Button btnPagar = new Button("Cadastro de Contas a Pagar");
	private Button btnCaixa = new Button("Cadastro de Caixa");
	private Button btnCompra = new Button("Cadastro de Compras");
	
	private Button btnProduto = new Button("Cadastro de Produto");
	
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
		
		painelMenu.add(btnProduto);
		btnProduto.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListaProduto cadProduto = new ListaProduto();
				painelConteudo.clear();
				painelConteudo.add(cadProduto);
			}
		});

		painelMenu.add(btnCliente);
		btnCliente.addClickHandler(new 
				ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListaCliente cad = new ListaCliente();
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
	
		painelMenu.add(btnReceber);
		btnReceber.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListaReceber cadReceber = new ListaReceber();
				painelConteudo.clear();
				painelConteudo.add(cadReceber);
			}
		});
		

		painelMenu.add(btnPagar);
		btnPagar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListaPagar cadPagar = new ListaPagar();
				painelConteudo.clear();
				painelConteudo.add(cadPagar );
			}
		});
		painelMenu.add(btnCompra);
		btnCompra.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListaCompra cadCompra = new ListaCompra();
				painelConteudo.clear();
				painelConteudo.add(cadCompra);
			}
		});
	}
	
}
