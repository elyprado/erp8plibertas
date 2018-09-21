package erp.libertas.client.produto;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import erp.libertas.shared.Fornecedor;

public class ItemProduto extends Composite {
	private Label lblNome = new Label();
	private Label lblId = new Label();
	private Button btnAlterar = new Button("Alterar");
	private HorizontalPanel painel = new HorizontalPanel();
	private Fornecedor fornecedor;
	private ListaProduto listaFornecedor;
	
	public ItemProduto(ListaProduto listaFornecedor, Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		this.listaFornecedor = listaFornecedor;
		lblNome.setText(fornecedor.getNome());
		lblId.setText(fornecedor.getIdfornecedor()+"-");
		
		lblId.setWidth("100px");
		lblNome.setWidth("300px");
		
		painel.add(lblId);
		painel.add(lblNome);
		painel.add(btnAlterar);
		initWidget(painel);
		
		painel.setStyleName("itemLista");
	}
}


