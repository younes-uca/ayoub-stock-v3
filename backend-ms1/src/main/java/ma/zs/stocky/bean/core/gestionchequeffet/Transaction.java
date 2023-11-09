package ma.zs.stocky.bean.core.gestionchequeffet;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.chequeffet.Instrument;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "transaction")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="transaction_seq",sequenceName="transaction_seq",allocationSize=1, initialValue = 1)
public class Transaction   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateTransaction ;
    private LocalDateTime dateEncaissement ;
    @Column(length = 500)
    private String pathCheque;
    @Column(length = 500)
    private String description;

    private TypeTransaction typeTransaction ;
    private Instrument instrument ;
    private Compte compte ;


    public Transaction(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="transaction_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateTransaction(){
        return this.dateTransaction;
    }
    public void setDateTransaction(LocalDateTime dateTransaction){
        this.dateTransaction = dateTransaction;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypeTransaction getTypeTransaction(){
        return this.typeTransaction;
    }
    public void setTypeTransaction(TypeTransaction typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Instrument getInstrument(){
        return this.instrument;
    }
    public void setInstrument(Instrument instrument){
        this.instrument = instrument;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Compte getCompte(){
        return this.compte;
    }
    public void setCompte(Compte compte){
        this.compte = compte;
    }
    public LocalDateTime getDateEncaissement(){
        return this.dateEncaissement;
    }
    public void setDateEncaissement(LocalDateTime dateEncaissement){
        this.dateEncaissement = dateEncaissement;
    }
    public String getPathCheque(){
        return this.pathCheque;
    }
    public void setPathCheque(String pathCheque){
        this.pathCheque = pathCheque;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction transaction = (Transaction) o;
        return id != null && id.equals(transaction.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

