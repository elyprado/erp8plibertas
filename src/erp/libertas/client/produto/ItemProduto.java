package erp.libertas.client.produto;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import erp.libertas.shared.Produto;

public class ItemProduto extends Composite {
	private Label lblNome = new Label();
	private Label lblId = new Label();
	private Button btnAlterar = new Button("Alterar");
	private HorizontalPanel painel = new HorizontalPanel();
	private Produto produto;
	private ListaProduto listaProduto;
	
	public ItemProduto(ListaProduto listaProduto, Produto produto) {
		this.produto = produto;
		this.listaProduto = listaProduto;
		lblNome.setText(produto.getDescricao());
		lblId.setText(produto.getIdProduto()+"-");
		
		lblId.setWidth("100px");
		lblNome.setWidth("300px");
		
		painel.add(lblId);
		painel.add(lblNome);
		painel.add(btnAlterar);
		initWidget(painel);
		
		painel.setStyleName("itemLista");
	}

	
}


