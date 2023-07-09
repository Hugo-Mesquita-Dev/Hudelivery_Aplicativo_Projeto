
package br.edu.ifpe.model.classes;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeProduto", length = 60, nullable = false)
    private String nomeProduto;

    @Column(name = "valorProduto", nullable = false)
    private double valorProduto;

    @Column(name = "quantProduto", length = 6, nullable = false)
    private int quantProduto;
    
    @Column(name = "prodInativo", nullable = false)
    private boolean produtoInativo = false; 

    public Produto() {
    }

    public Produto(String nomeProduto, double valorProduto, int quantProduto, boolean produtoInativo) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.produtoInativo = produtoInativo;
    }

    public int getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantProduto() {
        return quantProduto;
    }

    public void setQuantProduto(int quantProduto) {
        this.quantProduto = quantProduto;
    }
    
    public boolean getProdutoInativo() {
        return produtoInativo;
    }

    public void setProdutoInativo(boolean produtoInativo) {
        this.produtoInativo = produtoInativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorProduto) != Double.doubleToLongBits(other.valorProduto)) {
            return false;
        }
        if (this.quantProduto != other.quantProduto) {
            return false;
        }
        if (!Objects.equals(this.nomeProduto, other.nomeProduto)) {
            return false;
        }
        if (!Objects.equals(this.produtoInativo, other.produtoInativo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nomeProduto=" + nomeProduto + ", valorProduto=" + valorProduto + 
                ", quantProduto=" + quantProduto + ", produtoInativo=" + produtoInativo + '}';
    }
    
}
