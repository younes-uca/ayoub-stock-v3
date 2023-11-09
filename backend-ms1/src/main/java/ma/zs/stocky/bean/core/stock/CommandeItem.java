package ma.zs.stocky.bean.core.stock;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "commande_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="commande_item_seq",sequenceName="commande_item_seq",allocationSize=1, initialValue = 1)
public class CommandeItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Produit produit ;
    private Commande commande ;


    public CommandeItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="commande_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Commande getCommande(){
        return this.commande;
    }
    public void setCommande(Commande commande){
        this.commande = commande;
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
        CommandeItem commandeItem = (CommandeItem) o;
        return id != null && id.equals(commandeItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

