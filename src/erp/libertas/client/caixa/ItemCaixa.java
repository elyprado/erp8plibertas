package erp.libertas.client.caixa;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import erp.libertas.client.caixa.ListaCaixa;
import erp.libertas.shared.Caixa;

public class ItemCaixa extends Composite {
    
	private Label lblNome = new Label();
	private Label lblId = new Label();
	private Button btnAlterar = new Button("Alterar");
	private HorizontalPanel painel = new HorizontalPanel();
	private Caixa caixa;
	private ListaCaixa listaCaixa;
	
	public ItemCaixa(ListaCaixa listaCaixa, Caixa caixa) {
		this.caixa = caixa;
		this.listaCaixa = listaCaixa;
		lblNome.setText(caixa.getDescricao());
		lblId.setText(caixa.getIdCaixa()+"-");
		
		lblId.setWidth("100px");
		lblNome.setWidth("300px");
		
		painel.add(lblId);
		painel.add(lblNome);
		painel.add(btnAlterar);
		initWidget(painel);
		
		painel.setStyleName("itemLista");
	}
}
