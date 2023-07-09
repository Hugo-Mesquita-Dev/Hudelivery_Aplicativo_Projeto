
package br.edu.ifpe.model.dao;

import br.edu.ifpe.model.classes.Produto;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;


public class T1ProdutoDAOTest {

    private static Produto produto;

    @BeforeClass
    public static void deveInserirProdutos() {
        produto = new Produto("nome000", 3, 4, true);
        ProdutoDAO.getInstance().inserir(produto);

    }

    @Test
    public void deve1RecuperarProduto() {
        List<Produto> produtos = ProdutoDAO.getInstance().listarTodos();
        assertEquals("deveRecuperarProduto", produto,
                produtos.get(produtos.size() - 1));
    }

    @Test
    public void deve2AlterarProduto() {
        produto.setNomeProduto("nomeAlterado");
        produto.setQuantProduto(1212);

        ProdutoDAO.getInstance().alterar(produto);
        List<Produto> produtos = ProdutoDAO.getInstance().listarTodos();
        assertEquals("deveAlterarProduto", produto,
                produtos.get(produtos.size() - 1));
    }

    @Test
    public void deve3RecuperarTodosProdutos() {
        List<Produto> produtos = ProdutoDAO.getInstance().listarTodos();
        assertTrue(produtos.contains(produto));
    }

    @AfterClass()
    public static void deveDeletarProdutos() {
        ProdutoDAO.getInstance().deletar(produto);
    }

}
