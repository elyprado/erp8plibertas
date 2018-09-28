package erp.libertas.client.Receber;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import erp.libertas.shared.Receber;

public class ItemReceber extends Composite {
	private Label lblNome = new Label();
	private Label lblId = new Label();
	private Button btnAlterar = new Button("Alterar");
	private HorizontalPanel painel = new HorizontalPanel();
	private Receber receber;
	private ListaReceber listaReceber;
	
	public ItemReceber(ListaReceber listaReceber, Receber receber) {
		this.receber = receber;
		this.listaReceber = listaReceber;
		lblNome.setText(receber.getDescricao());
		lblId.setText(receber.getIdReceber()+"-");
		
		lblId.setWidth("100px");
		lblNome.setWidth("300px");
		
		painel.add(lblId);
		painel.add(lblNome);
		painel.add(btnAlterar);
		initWidget(painel);
		
		painel.setStyleName("itemLista");
}}
