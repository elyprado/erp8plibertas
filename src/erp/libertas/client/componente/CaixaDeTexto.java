package erp.libertas.client.componente;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CaixaDeTexto extends Composite {
	private VerticalPanel painel = new VerticalPanel();
	private Label lbl = new Label();
	private TextBox txt = new TextBox();
	
	public CaixaDeTexto(String titulo) {
		lbl.setText(titulo);
		
		painel.add(lbl);
		painel.add(txt);
		
		lbl.setStyleName("estilotexto");
		txt.setStyleName("caixa");
		
		initWidget(painel);
	}
	
	public String getText() {
		return txt.getText();
	}
	public void setText(String text) {
		txt.setText(text);
	}
}
