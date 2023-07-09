
package br.edu.ifpe.model.negocio;

import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.dao.EnderecoDAO;
import java.util.List;


public class EnderecoNegocio {
    
    EnderecoDAO enderecoJDBC = new EnderecoDAO();
    
    public void inserirEndereco (Endereco endereco){
        enderecoJDBC.inserir(endereco);
    }
 
    public void alterarEndereco (Endereco endereco){
        enderecoJDBC.alterar(endereco);
    }
    
    public Endereco recuperarEndereco (int codigo){
        return enderecoJDBC.recuperar(codigo);
    }
    
    public void deletarEndereco (Endereco endereco){
        enderecoJDBC.deletar(endereco);
    }
    
    public List<Endereco> listarTodosEnderecos(){
        return enderecoJDBC.listarTodos();
    }
       
}
