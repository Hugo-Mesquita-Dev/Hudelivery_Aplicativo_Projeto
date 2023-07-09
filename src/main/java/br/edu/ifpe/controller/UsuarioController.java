
package br.edu.ifpe.controller;

import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.negocio.UsuarioNegocio;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class UsuarioController implements Serializable{
    
    private Usuario usuario = new Usuario();    
    private UsuarioNegocio model = new UsuarioNegocio();
    
    public UsuarioController(){
    }
    
    public void inserirUsuarioAction() {        
        model.inserirUsuario(this.usuario);
        System.out.println("Usuario: " + this.getUsuario().getNome());
    }
    
    public void inserirUsuarioAction(Usuario usuario) {
        model.inserirUsuario(usuario);
    }

    public void alterarUsuarioAction(Usuario usuario) {
        model.alterarUsuario(usuario);
    }

    public Usuario recuperarUsuarioAction(int codigo) {
        return model.recuperarUsuario(codigo);
    }

    public void deletarUsuarioAction(Usuario usuario) {
        model.deletarUsuario(usuario);
    }

    public List<Usuario> listarTodosUsuariosAction() {
        return model.listarTodosUsuarios();
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
