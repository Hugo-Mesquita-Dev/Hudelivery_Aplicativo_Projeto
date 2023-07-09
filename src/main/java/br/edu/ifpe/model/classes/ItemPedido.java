
package br.edu.ifpe.model.classes;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ItemPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Produto produto;
    private double quantidade;

    public ItemPedido() {

    }

    public ItemPedido(Produto produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double total() {
        return produto.getValorProduto() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" + "produto=" + produto + ", quantidade=" + quantidade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.produto);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.quantidade) ^ (Double.doubleToLongBits(this.quantidade) >>> 32));
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
        final ItemPedido other = (ItemPedido) obj;
        if (Double.doubleToLongBits(this.quantidade) != Double.doubleToLongBits(other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

 
}
