
package br.edu.ifpe.controller;

import br.edu.ifpe.model.classes.Cliente;
import br.edu.ifpe.model.negocio.ClienteNegocio;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@SuppressWarnings("serial")
@Named(value = "clienteController")
@ViewScoped
public class ClienteController implements Serializable {

    private ClienteNegocio clienteModel = null;
    private Cliente cliente;
    private Cliente selectedCliente;

    private List<Cliente> clientesFiltrados;

    public ClienteController() {
        this.cliente = new Cliente();
        this.clienteModel = new ClienteNegocio();
        String codigo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (codigo != null) {
            this.selectedCliente = clienteModel.recuperarCliente(Integer.parseInt(codigo));
        }
    }

    public void inserirClienteAction() {
        this.clienteModel.inserirCliente(this.cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Cadastrado com Sucesso"));
        
        
    }

    public String alterarClienteAction() {
        this.clienteModel.alterarCliente(this.selectedCliente);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente alterado com sucesso"));
        FacesMessage mensagem = new FacesMessage("Cliente Alterado com Sucesso");
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, mensagem);
        return "listarCliente.xhtml?faces-redirect=true";
    }

    public Cliente recuperarClienteAction(int codigo) {
        return clienteModel.recuperarCliente(codigo);
    }

    public String deletarClienteAction(Cliente cliente) {
        this.clienteModel.deletarCliente(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente deletado com sucesso."));
        return "listarCliente.xhtml?faces-redirect=true";
    }
    
    public String inativarClienteAction(Cliente cliente){
        this.clienteModel.inativarCliente(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente deletado com sucesso."));
        return "listarCliente.xhtml?faces-redirect=true";
    }

    public List<Cliente> listarTodosClientesAction() {
        return clienteModel.listarTodosClientes();
    }
    
    public List<Cliente> listarTodosClientesAtivosAction() {
        return clienteModel.listarTodosClientesAtivos();
    }

    public ClienteNegocio getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteNegocio clienteModel) {
        this.clienteModel = clienteModel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public List<Cliente> getClientesFiltrados() {
        return clientesFiltrados;
    }

    public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
        this.clientesFiltrados = clientesFiltrados;
    }

    public String linkAlterar(Integer id) {
        return "alterarCliente.xhtml?faces-redirect=true&id=" + id;
    }

    public String linkListar() {
        return "listarCliente.xhtml?faces-redirect=true";
    }

    public String linkHome() {
        return "loginCliente.xhtml?faces-redirect=true";
    }

    public String linkCadastroCliente() {
        return "cadastroCliente.xhtml?faces-redirect=true";
    }

    public String linkCadastroProduto() {
        return "cadastroProduto.xhtml?faces-redirect=true";
    }

    public String linkListaCliente() {
        return "listarCliente.xhtml?faces-redirect=true";

    }

    public String linkListaProduto() {
        return "listarProduto.xhtml?faces-redirect=true";
    }

    public String linkListaPedidos() {
        return "listaPedidos.xhtml?faces-redirect=true";
    }

    public String linkNovoPedido() {
        return "pedido.xhtml?faces-redirect=true";
    }

    public String linkVoltar() {
        return "home.xhtml?faces-redirect=true";

    }

}
