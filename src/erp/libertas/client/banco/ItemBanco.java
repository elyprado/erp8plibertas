package erp.libertas.client.banco;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import erp.libertas.client.banco.ListaBanco;
import erp.libertas.shared.Banco;

public class ItemBanco extends Composite{

    private Label lblNome = new Label();
    private Label lblId = new Label();
    private Button btnAlterar = new Button("Alterar");
    private HorizontalPanel painel = new HorizontalPanel();
    private Banco banco;
    private ListaBanco listaBanco;
	
    public ItemBanco(ListaBanco listaBanco, Banco banco) {
	
	this.banco = banco;
	this.listaBanco = listaBanco;
	lblNome.setText(banco.getNome());
	lblId.setText(banco.getIdBanco()+"-");
	
	lblId.setWidth("100px");
	lblNome.setWidth("300px");
	
	painel.add(lblId);
	painel.add(lblNome);
	painel.add(btnAlterar);
	initWidget(painel);
	
	painel.setStyleName("itemLista");
    }

}
