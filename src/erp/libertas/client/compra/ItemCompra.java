package erp.libertas.client.compra;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import erp.libertas.shared.Compra;

public class ItemCompra extends Composite{
	private Label lblNota = new Label();
	private Label lblId = new Label();
	private Button btnAlterar = new Button("Alterar");
	private HorizontalPanel painel = new HorizontalPanel();
	private Compra compra;
	private ListaCompra listaCompra;
	
	public ItemCompra(ListaCompra listacompra, Compra compra) {
		this.compra = compra;
		this.listaCompra = listacompra;
		lblNota.setText(String.valueOf(compra.getNumNotaFiscal()));
		lblId.setText(compra.getIdCompra()+"-");
		
		lblId.setWidth("100px");
		lblNota.setWidth("300px");
		
		painel.add(lblId);
		painel.add(lblNota);
		painel.add(btnAlterar);
		initWidget(painel);
		
		painel.setStyleName("itemLista");
	}
}
