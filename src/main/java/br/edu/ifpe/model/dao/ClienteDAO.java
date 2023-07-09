
package br.edu.ifpe.model.dao;

import br.edu.ifpe.model.dao.resources.HibernateUtill;
import br.edu.ifpe.model.classes.Cliente;
import br.edu.ifpe.model.dao.interfaces.ClienteInterfaceDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ClienteDAO implements ClienteInterfaceDAO {

    private final HibernateUtill UTILL;
    private static ClienteDAO instance;
    private Session session;

    public ClienteDAO() {
        UTILL = HibernateUtill.getInstance();
    }

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    @Override
    public void inserir(Cliente cliente) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(cliente);
            transaction.commit();
        } catch (Exception createClienteException) {
            System.out.println(createClienteException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Cliente recuperar(Integer codigo) {
        try {
            session = UTILL.getSession();
            return (Cliente) session.createQuery(
                    "FROM Cliente where id=" + codigo).getSingleResult();
        } catch (Exception readClienteException) {
            System.out.println(readClienteException.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(cliente);
            transaction.commit();
        } catch (Exception updateClienteException) {
            System.out.println(updateClienteException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Cliente cliente) {
        session = UTILL.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(cliente);
            transaction.commit();
        } catch (Exception delClienteException) {
            System.out.println(delClienteException.getMessage());
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
    
    public void inativar(Cliente cliente){
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        if(cliente.getClienteInativo() == false){
            cliente.setClienteInativo(true);
        }
        try {
            session.update(cliente);
            transaction.commit();
        } catch (Exception updateClienteException) {
            System.out.println(updateClienteException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        session = UTILL.getSession();
        List<Cliente> clientes = null;
        try {
            clientes = (List) session.createQuery
                                ("FROM Cliente").getResultList();
        } catch (Exception readAllClientesException) {
            System.out.println(readAllClientesException.getMessage());
        } finally {
            session.close();
        }
        return clientes;
      
    }
    
    public List<Cliente>ListarTodosAtivos(){
        session = UTILL.getSession();
        List<Cliente> clientes = null;
        try {
            clientes = (List) session.createQuery
                                ("FROM Cliente WHERE cliInativo = false").getResultList();
        } catch (Exception readAllClientesException) {
            System.out.println(readAllClientesException.getMessage());
        } finally {
            session.close();
        }
        return clientes;
    }
    
}
