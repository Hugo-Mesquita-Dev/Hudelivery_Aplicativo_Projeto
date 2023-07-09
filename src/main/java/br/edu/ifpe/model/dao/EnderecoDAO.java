
package br.edu.ifpe.model.dao;

import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.dao.interfaces.EnderecoInterfaceDAO;
import br.edu.ifpe.model.dao.resources.HibernateUtill;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EnderecoDAO implements EnderecoInterfaceDAO {

    private final HibernateUtill UTILL;
    private static EnderecoDAO instance;
    private Session session;

    public EnderecoDAO() {
        UTILL = HibernateUtill.getInstance();
    }

    public static EnderecoDAO getInstance() {
        if (instance == null) {
            instance = new EnderecoDAO();
        }
        return instance;
    }

    @Override
    public void inserir(Endereco endereco) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(endereco);
            transaction.commit();
        } catch (Exception createEnderecoException) {
            System.out.println(createEnderecoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Endereco recuperar(Integer codigo) {
        try {
            session = UTILL.getSession();
            return (Endereco) session.createQuery(
                    "FROM Endereco where id=" + codigo).getSingleResult();
        } catch (Exception readEnderecoException) {
            System.out.println(readEnderecoException.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Endereco endereco) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(endereco);
            transaction.commit();
        } catch (Exception updateEnderecoException) {
            System.out.println(updateEnderecoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Endereco endereco) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(endereco);
            transaction.commit();
        } catch (Exception delEnderecoException) {
            System.out.println(delEnderecoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Endereco> listarTodos() {
        session = UTILL.getSession();
        List<Endereco> enderecos = null;
        try {
            enderecos = (List) session.createQuery
                                            ("FROM Endereco").getResultList();
        } catch (Exception readAllEnderecosException) {
            System.out.println(readAllEnderecosException.getMessage());
        } finally {
            session.close();
            return enderecos;
        }
    }
}
