
package br.edu.ifpe.model.negocio;

import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.dao.UsuarioDao;
import br.edu.ifpe.model.dao.resources.HibernateUtill;
import java.io.Serializable;
import java.util.List;


public class UsuarioNegocio implements Serializable {

    private static UsuarioNegocio instance;
    private final HibernateUtill UTILL;

    UsuarioDao usuarioJDBC = new UsuarioDao();

    public UsuarioNegocio() {
        UTILL = HibernateUtill.getInstance();
    }

    public static UsuarioNegocio getInstance() {
        if (instance == null) {
            instance = new UsuarioNegocio();
        }
        return instance;
    }

    public void inserirUsuario(Usuario usuario) {        
        usuarioJDBC.inserir(usuario);
    }

    public void alterarUsuario(Usuario usuario) {
        usuarioJDBC.alterar(usuario);
    }

    public Usuario recuperarUsuario(int codigo) {
        return usuarioJDBC.recuperar(codigo);
    }

    public void deletarUsuario(Usuario usuario) {
        usuarioJDBC.deletar(usuario);
    }

    public List<Usuario> listarTodosUsuarios() {
        return usuarioJDBC.listarTodos();
    }

    public Usuario recuperarUsuario(String cod) {
        return this.recuperarUsuario(cod);
    }

}
