
package br.edu.ifpe.model.dao;

import br.edu.ifpe.model.classes.Pedido;
import br.edu.ifpe.model.dao.interfaces.PedidoInterfaceDAO;
import br.edu.ifpe.model.dao.resources.HibernateUtill;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.ws.rs.HEAD;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PedidoDAO implements PedidoInterfaceDAO {

    private final HibernateUtill UTILL;
    private static PedidoDAO instance;
    private Session session;

    private PedidoDAO() {
        UTILL = HibernateUtill.getInstance();
    }

    public static PedidoDAO getInstance() {
        if (instance == null) {
            instance = new PedidoDAO();
        }
        return instance;
    }

    @Override
    public void inserir(Pedido pedido) {
        Session session = UTILL.getSession();
        try {
            session.getTransaction().begin();
            session.save(pedido);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao INSERIR " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Pedido pedido) {
        Session session = UTILL.getSession();
        try {
            session.getTransaction().begin();
            session.update(pedido);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Erro ao ATUALIZAR " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public Pedido recuperar(Integer codigo) {
        Pedido pedido = null;

        Session session = UTILL.getSession();
        try {
            pedido = session.find(Pedido.class, codigo);
        } catch (Exception e) {
            System.out.println("Erro ao recuperar " + e.toString());
        }finally{
            session.close();
        }

        return pedido;
    }

    @Override
    public void deletar(Pedido pedido) {
        Session session = UTILL.getSession();

        try {
            session.getTransaction().begin();
            session.delete(pedido);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao DELETAR " + e.toString());
        }finally{
            session.close();
        }
    }

    @Override
    public List<Pedido> listarTodos() {
        List<Pedido> pedidos = new ArrayList<>();
        Session session = UTILL.getSession();
        
        try{
            pedidos = session.createQuery("FROM Pedido").getResultList();
        }catch(Exception e){
            System.out.println("Ocorreu um erro ao listar todos : "
             + "\n" + e.getMessage());
        }finally{
            session.close();
        }

        return pedidos;
    }

}
