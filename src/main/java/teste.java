
import br.edu.ifpe.controller.pedido.PedidoController;
import br.edu.ifpe.model.classes.Pedido;
import br.edu.ifpe.model.classes.Produto;
import br.edu.ifpe.model.classes.ItemPedido;
import br.edu.ifpe.model.dao.ClienteDAO;
import br.edu.ifpe.model.dao.PedidoDAO;
import br.edu.ifpe.model.dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;


public class teste {

    public static void main(String[] args) {
        
//       Endereco endereco = new Endereco("1", "1", "1", "1",
//                "1", 0, "1");
//        EnderecoDAO.getInstance().inserir(endereco);
//        
//        Cliente cliente = new Cliente("1", "teste", "1", 
//                LocalDate.now(), "1", "t", endereco);
//        ClienteDAO.getInstance().inserir(cliente);

                
                List<ItemPedido> pe = new ArrayList();
                
                ItemPedido e = new ItemPedido(ProdutoDAO.getInstance().recuperar(2), 5);
                pe.add(e);
        
        Pedido  p = new Pedido(ClienteDAO.getInstance().recuperar(1), 3,"status",pe);
        
        PedidoController ppp = new PedidoController();
        
        
        
        p.setStatus("t");
        
        PedidoDAO.getInstance().alterar(p);
        
        
    }
}
