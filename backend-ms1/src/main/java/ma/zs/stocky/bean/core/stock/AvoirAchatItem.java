package ma.zs.stocky.bean.core.stock;

import java.util.Objects;





import ma.zs.stocky.bean.core.commun.Depot;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "avoir_achat_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avoir_achat_item_seq",sequenceName="avoir_achat_item_seq",allocationSize=1, initialValue = 1)
public class AvoirAchatItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal montantAvoir = BigDecimal.ZERO;
    private BigDecimal quantite = BigDecimal.ZERO;

    private Produit produit ;
    private Depot depot ;
    private AvoirAchat avoirAchat ;


    public AvoirAchatItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="avoir_achat_item_seq")
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
    public BigDecimal getMontantAvoir(){
        return this.montantAvoir;
    }
    public void setMontantAvoir(BigDecimal montantAvoir){
        this.montantAvoir = montantAvoir;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Depot getDepot(){
        return this.depot;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public AvoirAchat getAvoirAchat(){
        return this.avoirAchat;
    }
    public void setAvoirAchat(AvoirAchat avoirAchat){
        this.avoirAchat = avoirAchat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirAchatItem avoirAchatItem = (AvoirAchatItem) o;
        return id != null && id.equals(avoirAchatItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

