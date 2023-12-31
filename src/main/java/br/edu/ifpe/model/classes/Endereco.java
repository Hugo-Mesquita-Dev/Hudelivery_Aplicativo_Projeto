
package br.edu.ifpe.model.classes;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class Endereco implements Serializable{
 
    @Column( length = 20, nullable = false)
    private String estado;
    
    @Column( name = "cidade", nullable = false)
    private String cidade;
    
    @Column( name = "cep", length = 20, nullable = false)
    private String cep;
    
    @Column(name = "bairro", nullable = false)
    private String bairro;
    
    @Column( name = "logradouro", length = 20, nullable = false)
    private String logradouro;
    
    @Column( name = "numero_residencia", length = 10, nullable = false)
    private Integer numero;
    
    @Column( name = "complemento", length = 20, nullable = false)
    private String complemento;

    public Endereco() {
    }

    public Endereco(String estado, String cidade, String cep,
            String bairro, String logradouro, Integer numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" + "estado=" + estado + ", cidade=" + cidade + 
                ", cep=" + cep + ", bairro=" + bairro + ", logradouro=" + 
                logradouro + ", numero=" + numero + ", complemento=" + 
                complemento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.estado);
        hash = 67 * hash + Objects.hashCode(this.cidade);
        hash = 67 * hash + Objects.hashCode(this.cep);
        hash = 67 * hash + Objects.hashCode(this.bairro);
        hash = 67 * hash + Objects.hashCode(this.logradouro);
        hash = 67 * hash + Objects.hashCode(this.numero);
        hash = 67 * hash + Objects.hashCode(this.complemento);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.logradouro, other.logradouro)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    

}
