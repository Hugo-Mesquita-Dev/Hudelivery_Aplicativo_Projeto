
package br.edu.ifpe.model.negocio;

import br.edu.ifpe.model.classes.Produto;
import br.edu.ifpe.model.dao.ProdutoDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class ProdutoNegocio implements Serializable {

    private static ProdutoNegocio instance;

    public static ProdutoNegocio getInstance() {
        if (instance == null) {
            instance = new ProdutoNegocio();
        }
        return instance;
    }

    ProdutoDAO produtoJDBC = new ProdutoDAO();

    public void inserirProduto(Produto produto) {
        if (produto.getQuantProduto() < 0) {
            FacesMessage mensagem = new FacesMessage
                        ("A quantidade do produto deve ser maior que zero!");
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, mensagem);
        }else{
            produtoJDBC.inserir(produto);
        } 
    }

    public void alterarProduto(Produto produto) {
        produtoJDBC.alterar(produto);
    }

    public Produto recuperarProduto(int codigo) {
        return produtoJDBC.recuperar(codigo);
    }

    public void deletarProduto(Produto produto) {
        produtoJDBC.deletar(produto);
    }
    
    public void inativarProduto (Produto produto){
        produtoJDBC.inativar(produto);
    }

    public List<Produto> listarTodosProdutos() {
        return produtoJDBC.listarTodos();
    }
    
    public List<Produto> listarTodosProdutosAtivos(){
        return produtoJDBC.ListarTodosAtivos();
    }

}
