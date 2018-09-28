package erp.libertas.client.pagar;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import erp.libertas.shared.Pagar;

public class ItemPagar extends Composite {
	private Label lblId = new Label();
	private Label lblDataLancamento = new Label();
	private Label lblDataVencimento = new Label();
	private Label lblDataPagamento = new Label();
	private Label lblDescricao = new Label();
	private Label lblValor = new Label();
	private Label lblValorPago = new Label();
	private Button btnAlterar = new Button("Alterar");
	private HorizontalPanel painel = new HorizontalPanel();
	Pagar pagar;
	ListaPagar listaPagar;
	
	public ItemPagar(ListaPagar listaPagar , Pagar pagar) {
		this.pagar = pagar;
		this.listaPagar = listaPagar ;
		lblDataLancamento.setText(pagar.getDataLancto());
		lblDataPagamento.setText(pagar.getDataPagamento());
		lblDataVencimento.setText(pagar.getDataVencimento());
		lblDescricao.setText(pagar.getDescricao());
		lblValor.setText(Double.toString(pagar.getValor()));
		lblValorPago.setText(Double.toString(pagar.getValorPago()));
		lblId.setText(pagar.getIdpagar()+"-");
		
		lblId.setWidth("100px");
		lblDataLancamento.setWidth("300px");
		lblDataPagamento.setWidth("300px");
		lblDataVencimento.setWidth("300px");
		lblDescricao.setWidth("300px");
		lblValor.setWidth("300px");
		lblValorPago.setWidth("300px");
		
		painel.add(lblId);
		painel.add(lblDataLancamento);
		painel.add(lblDataPagamento);
		painel.add(lblDataVencimento);
		painel.add(lblDescricao);
		painel.add(lblValor);
		painel.add(lblValorPago);
		painel.add(btnAlterar);
		initWidget(painel);
		
		painel.setStyleName("itemLista");
	}
}


