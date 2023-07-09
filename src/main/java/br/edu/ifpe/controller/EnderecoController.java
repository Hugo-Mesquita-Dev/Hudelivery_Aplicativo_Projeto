
package br.edu.ifpe.controller;

import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.negocio.EnderecoNegocio;

import java.util.List;


public class EnderecoController {

    EnderecoNegocio enderecoModel = new EnderecoNegocio();

    public void inserirEnderecoAction(Endereco endereco) {
        enderecoModel.inserirEndereco(endereco);
    }

    public void alterarEnderecoAction(Endereco endereco) {
        enderecoModel.alterarEndereco(endereco);
    }

    public Endereco recuperarEnderecoAction(int codigo) {
        return enderecoModel.recuperarEndereco(codigo);
    }

    public void deletarEnderecoAction(Endereco endereco) {
        enderecoModel.deletarEndereco(endereco);
    }

    public List<Endereco> listarTodosEnderecosAction() {
        return enderecoModel.listarTodosEnderecos();
    }

}
