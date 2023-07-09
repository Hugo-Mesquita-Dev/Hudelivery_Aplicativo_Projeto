
package br.edu.ifpe.model.classes;

import br.com.caelum.stella.bean.validation.CPF;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeCliente", length = 30, nullable = false)
    private String nomeCliente;    

    @Column(name = "cpfCliente", length = 11, nullable = false)
    @CPF(message = "CPF inválido")
    private String cpfCliente;    

    @Column(name = "telefoneCliente", nullable = false)
    private String telefoneCliente;

    @Column(name = "emailCliente", nullable = false)
    private String emailCliente;
    
    private Endereco endereco;
    
    @Column(name = "cliInativo", nullable = false)
    private boolean clienteInativo = false; 
    
    public Cliente() {
        this.endereco = new Endereco();
    }
    
    public Cliente(String nome) {
        this.nomeCliente = nome;
    }

    public Cliente(String nomeCliente, String senhaCliente, 
            String cpfCliente, LocalDate dtNascimentoCliente, 
            String telefoneCliente, String emailCliente, Endereco endereco, boolean clienteInativo) {
        this.nomeCliente = nomeCliente;        
        this.cpfCliente = cpfCliente;        
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
        this.endereco = endereco;
        this.clienteInativo = clienteInativo;
    }

    public int getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
   
    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public boolean getClienteInativo() {
        return clienteInativo;
    }

    public void setClienteInativo(boolean clienteInativo) {
        this.clienteInativo = clienteInativo;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.nomeCliente);
        hash = 71 * hash + Objects.hashCode(this.cpfCliente);
        hash = 71 * hash + Objects.hashCode(this.telefoneCliente);
        hash = 71 * hash + Objects.hashCode(this.emailCliente);
        hash = 71 * hash + Objects.hashCode(this.endereco);
        hash = 71 * hash + Objects.hashCode(this.clienteInativo);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomeCliente, other.nomeCliente)) {
            return false;
        }
        if (!Objects.equals(this.cpfCliente, other.cpfCliente)) {
            return false;
        }
        if (!Objects.equals(this.telefoneCliente, other.telefoneCliente)) {
            return false;
        }
        if (!Objects.equals(this.emailCliente, other.emailCliente)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.clienteInativo, other.clienteInativo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente + 
                ", telefoneCliente=" + telefoneCliente + ", emailCliente=" + emailCliente + ", endereco=" + endereco + 
                ", clienteInativo=" + clienteInativo + '}';
    }
    
    
}
