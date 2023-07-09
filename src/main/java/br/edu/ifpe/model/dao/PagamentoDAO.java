
package br.edu.ifpe.model.dao;

import br.edu.ifpe.model.classes.Pagamento;
import br.edu.ifpe.model.dao.interfaces.PagamentoInterfaceDAO;
import br.edu.ifpe.model.dao.resources.HibernateUtill;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PagamentoDAO implements PagamentoInterfaceDAO {

    private final HibernateUtill UTILL;
    private static PagamentoDAO instance;
    private Session session;

    public PagamentoDAO() {
        UTILL = HibernateUtill.getInstance();
    }

    public static PagamentoDAO getInstance() {
        if (instance == null) {
            instance = new PagamentoDAO();
        }
        return instance;
    }

    @Override
    public void inserir(Pagamento pagamento) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(pagamento);
            transaction.commit();
        } catch (Exception createPagamentoException) {
            System.out.println(createPagamentoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Pagamento recuperar(Integer codigo) {
        try {
            session = UTILL.getSession();
            return (Pagamento) session.createQuery(
                    "FROM Pagamento where id=" + codigo).getSingleResult();
        } catch (Exception readPagamentoException) {
            System.out.println(readPagamentoException.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Pagamento pagamento) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(pagamento);
            transaction.commit();
        } catch (Exception updatePagamentoException) {
            System.out.println(updatePagamentoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Pagamento pagamento) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(pagamento);
            transaction.commit();
        } catch (Exception delPagamentoException) {
            System.out.println(delPagamentoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Pagamento> listarTodos() {
        session = UTILL.getSession();
        List<Pagamento> pagamentos = null;
        try {
            pagamentos = (List) session.createQuery("FROM Pagamento").getResultList();
        } catch (Exception readAllPagamentosException) {
            System.out.println(readAllPagamentosException.getMessage());
        } finally {
            session.close();
            return pagamentos;
        }
    }
}
