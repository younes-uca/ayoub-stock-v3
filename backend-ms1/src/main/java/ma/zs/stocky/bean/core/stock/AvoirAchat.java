package ma.zs.stocky.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.commun.Depot;
import ma.zs.stocky.bean.core.commun.EntrepriseSociete;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "avoir_achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avoir_achat_seq",sequenceName="avoir_achat_seq",allocationSize=1, initialValue = 1)
public class AvoirAchat   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateAvoir ;
    private BigDecimal montant = BigDecimal.ZERO;

    private EntrepriseSociete entrepriseSociete ;
    private Achat achat ;

    private List<AvoirAchatItem> avoirAchatItems ;

    public AvoirAchat(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="avoir_achat_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EntrepriseSociete getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSociete entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public LocalDateTime getDateAvoir(){
        return this.dateAvoir;
    }
    public void setDateAvoir(LocalDateTime dateAvoir){
        this.dateAvoir = dateAvoir;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Achat getAchat(){
        return this.achat;
    }
    public void setAchat(Achat achat){
        this.achat = achat;
    }
    @OneToMany(mappedBy = "avoirAchat")

    public List<AvoirAchatItem> getAvoirAchatItems(){
        return this.avoirAchatItems;
    }
    public void setAvoirAchatItems(List<AvoirAchatItem> avoirAchatItems){
        this.avoirAchatItems = avoirAchatItems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirAchat avoirAchat = (AvoirAchat) o;
        return id != null && id.equals(avoirAchat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

