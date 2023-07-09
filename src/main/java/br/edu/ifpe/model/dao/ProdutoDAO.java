
package br.edu.ifpe.model.dao;

import br.edu.ifpe.model.classes.ItemPedido;
import br.edu.ifpe.model.classes.Produto;
import br.edu.ifpe.model.dao.interfaces.ProdutoInterfaceDAO;
import br.edu.ifpe.model.dao.resources.HibernateUtill;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProdutoDAO implements ProdutoInterfaceDAO {

    private final HibernateUtill UTILL;
    private static ProdutoDAO instance;
    private Session session;

    public ProdutoDAO() {
        UTILL = HibernateUtill.getInstance();
    }

    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAO();
        }
        return instance;
    }

    @Override
    public void inserir(Produto produto) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(produto);
            transaction.commit();
        } catch (Exception createProdutoException) {
            System.out.println(createProdutoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Produto recuperar(Integer codigo) {
        try {
            session = UTILL.getSession();
            return (Produto) session.createQuery(
                    "FROM Produto where id=" + codigo).getSingleResult();
        } catch (Exception readProdutoException) {
            System.out.println(readProdutoException.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Produto produto) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(produto);
            transaction.commit();
        } catch (Exception updateProdutoException) {
            System.out.println(updateProdutoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Produto produto) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(produto);
            transaction.commit();
        } catch (Exception delProdutoException) {
            System.out.println(delProdutoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }
    
    public void inativar(Produto produto){
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        if(produto.getProdutoInativo() == false){
            produto.setProdutoInativo(true);
        }
        try {
            session.update(produto);
            transaction.commit();
        } catch (Exception delProdutoException) {
            System.out.println(delProdutoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Produto> listarTodos() {
        session = UTILL.getSession();
        List<Produto> produtos = null;
        try {
            produtos = (List) session.createQuery("FROM Produto").getResultList();
        } catch (Exception readAllProdutosException) {
            System.out.println(readAllProdutosException.getMessage());
        } finally {
            session.close();
            return produtos;
        }
    }
    
    public List<Produto>ListarTodosAtivos(){
        session = UTILL.getSession();
        List<Produto> produtos = null;
        try {
           produtos = (List) session.createQuery
                                ("FROM Produto WHERE prodInativo = false").getResultList();
        } catch (Exception readAllProdutosException) {
            System.out.println(readAllProdutosException.getMessage());
        } finally {
            session.close();
        }
        return produtos;
    }
}