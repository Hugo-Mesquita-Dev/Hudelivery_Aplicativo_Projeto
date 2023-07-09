
package br.edu.ifpe.model.dao;

import br.edu.ifpe.model.classes.Cliente;
import br.edu.ifpe.model.classes.Endereco;
import java.time.LocalDate;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;


public class T2ClienteDAOTest {

    private static Cliente cliente;
    private static Endereco endereco;

    @BeforeClass
    public static void deveInserirClientes() {
        endereco = new Endereco("estado", "cidade", "cep", "bairro",
                "logradouro", 0, "complemento");
        EnderecoDAO.getInstance().inserir(endereco);

        cliente = new Cliente("nomeCliente", "senhaCliente", "cpfCliente",
                LocalDate.now(), "telefoneCliente", "emailCliente", endereco, true);
        ClienteDAO.getInstance().inserir(cliente);
    }

    @Test
    public void deve1RecuperarCliente() {
        List<Cliente> clientes = ClienteDAO.getInstance().listarTodos();
        assertEquals("deveRecuperarCliente", cliente,
                clientes.get(clientes.size() - 1));
    }

    @Test
    public void deve2AlterarClliente() {
        cliente.setNomeCliente("nomeAlterado");
        cliente.setEmailCliente("emailAlterado");

        ClienteDAO.getInstance().alterar(cliente);
        List<Cliente> clientes = ClienteDAO.getInstance().listarTodos();
        assertEquals("deveAlterarCliente", cliente,
                clientes.get(clientes.size() - 1));
    }

    @Test
    public void deve3RecuperarTodosClientes() {
        List<Cliente> clientes = ClienteDAO.getInstance().listarTodos();
        assertTrue(clientes.contains(cliente));
    }

    @AfterClass()
    public static void deveDeletarCliente() {
        ClienteDAO.getInstance().deletar(cliente);
        EnderecoDAO.getInstance().deletar(endereco);
    }

}
