package erp.libertas.client.cliente;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import erp.libertas.shared.Cliente;


public class ItemCliente extends Composite {
	private Label lblNome = new Label();
	private Label lblId = new Label();
	private Label lblEndereco = new Label();
	private Label lblBairro = new Label();
	private Label lblCpf = new Label();
	private Label lblEmail = new Label();
	private Label lblCidade = new Label();
	private Label lblTelefone = new Label();
	private Button btnAlterar = new Button("Alterar");
	private HorizontalPanel painel = new HorizontalPanel();
	private Cliente cliente;
	private ListaCliente listaCliente;

	public ItemCliente(ListaCliente listaCliente, Cliente cliente) {
		this.cliente = cliente;
		this.listaCliente = listaCliente;
		lblNome.setText(cliente.getNome());
		lblId.setText(cliente.getIdCliente() + "-");
        lblEndereco.setText(cliente.getEndereco());
        lblBairro.setText(cliente.getBairro());
        lblTelefone.setText(cliente.getTelefone());
        lblEmail.setText(cliente.getEmail());
        lblCidade.setText(cliente.getCidade().getNome());
        lblCpf.setText(cliente.getCpf());
		
        lblId.setWidth("100px");
		lblNome.setWidth("200px");
		lblCpf.setWidth("200px");
		lblNome.setWidth("200px");
		lblEndereco.setWidth("200px");
		lblBairro.setWidth("200px");
		lblCidade.setWidth("200px");
		lblTelefone.setWidth("200px");
		lblEmail.setWidth("200px");
		

		painel.add(lblId);
		painel.add(lblNome);
		painel.add(lblEndereco);
		painel.add(lblBairro);
		painel.add(lblCidade);
		painel.add(lblTelefone);
		painel.add(lblEmail);
		painel.add(lblCpf);
		painel.add(btnAlterar);
		initWidget(painel);

		painel.setStyleName("itemLista");
	}
}