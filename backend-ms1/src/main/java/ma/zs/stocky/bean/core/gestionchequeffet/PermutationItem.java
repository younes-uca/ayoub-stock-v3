package ma.zs.stocky.bean.core.gestionchequeffet;

import java.util.Objects;





import ma.zs.stocky.bean.core.commun.Depot;
import ma.zs.stocky.bean.core.stock.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "permutation_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="permutation_item_seq",sequenceName="permutation_item_seq",allocationSize=1, initialValue = 1)
public class PermutationItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;

    private Produit produit ;
    private Depot depot ;
    private Permutation permutation ;


    public PermutationItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="permutation_item_seq")
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
    public Depot getDepot(){
        return this.depot;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Permutation getPermutation(){
        return this.permutation;
    }
    public void setPermutation(Permutation permutation){
        this.permutation = permutation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermutationItem permutationItem = (PermutationItem) o;
        return id != null && id.equals(permutationItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

