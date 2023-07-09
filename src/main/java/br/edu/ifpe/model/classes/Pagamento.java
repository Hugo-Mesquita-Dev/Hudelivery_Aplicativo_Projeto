
package br.edu.ifpe.model.classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Embeddable
public class Pagamento implements Serializable {

    @Column(name = "tipoPagamento")
    @Enumerated(EnumType.STRING)
    private FormaPagamento tipoPagamento;
    
    @Column(name = "valorTotalPagamento", length = 6)
    private double valorTotalPagamento;
        
    public Pagamento() {
    }

    public FormaPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(FormaPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    } 

    public void setValorTotalPagamento(double valorTotalPagamento) {
        this.valorTotalPagamento = valorTotalPagamento;
    }
    
    public FormaPagamento[] formasDePagamento (){
        return FormaPagamento.values();
    }
    
    
    
}
