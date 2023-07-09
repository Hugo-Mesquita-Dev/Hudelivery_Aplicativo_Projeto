
package br.edu.ifpe.model.negocio;

import br.edu.ifpe.model.classes.Pedido;
import br.edu.ifpe.model.dao.ItemPedidoDAO;
import br.edu.ifpe.model.dao.PedidoDAO;
import br.edu.ifpe.model.dao.resources.HibernateUtill;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class PedidoNegocio {

    private static PedidoNegocio instance;
    private final HibernateUtill UTILL;

    PedidoDAO pedidoJDBC = PedidoDAO.getInstance();

    public PedidoNegocio() {
        UTILL = HibernateUtill.getInstance();
    }

    public static PedidoNegocio getInstance() {
        if (instance == null) {
            instance = new PedidoNegocio();
        }
        return instance;
    }

    public void inserirPedido(Pedido pedido) {
        pedidoJDBC.inserir(pedido);
        FacesMessage mensagem = new FacesMessage("Pedido efetuado com sucesso!");
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, mensagem);
    }

    public void alterarPedido(Pedido pedido) {
        pedidoJDBC.alterar(pedido);
    }

    public Pedido recuperarPedido(int codigo) {
        return pedidoJDBC.recuperar(codigo);
    }

    public void deletarPedido(Pedido pedido) {
        pedidoJDBC.deletar(pedido);
    }

    public List<Pedido> listarTodosPedidos() {
        return pedidoJDBC.listarTodos();
    }

    public Pedido recuperarPedido(String cod) {
        return this.recuperarPedido(cod);
    }

}
