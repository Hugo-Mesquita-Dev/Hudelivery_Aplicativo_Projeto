
package br.edu.ifpe.model.negocio;

import br.edu.ifpe.model.dao.ClienteDAO;
import br.edu.ifpe.model.classes.Cliente;
import java.io.Serializable;
import java.util.List;



public class ClienteNegocio implements Serializable {
    
    ClienteDAO clienteJDBC = new ClienteDAO();
    
    public void inserirCliente (Cliente cliente){
        clienteJDBC.inserir(cliente);
    }
 
    public void alterarCliente (Cliente cliente){
        clienteJDBC.alterar(cliente);
    }
    
    public Cliente recuperarCliente (int codigo){
        return clienteJDBC.recuperar(codigo);
    }
    
    public void deletarCliente (Cliente cliente){
        clienteJDBC.deletar(cliente);
    }
    
    public void inativarCliente (Cliente cliente){
        clienteJDBC.inativar(cliente);
    }
    
    public List<Cliente> listarTodosClientes(){
        return clienteJDBC.listarTodos();
    }
    
    public List<Cliente> listarTodosClientesAtivos(){
        return clienteJDBC.ListarTodosAtivos();
    } 
       
}
