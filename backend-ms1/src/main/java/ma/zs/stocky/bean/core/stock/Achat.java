package ma.zs.stocky.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.commun.EtatAchat;
import ma.zs.stocky.bean.core.commun.Fournisseur;
import ma.zs.stocky.bean.core.commun.Depot;
import ma.zs.stocky.bean.core.commun.EntrepriseSociete;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="achat_seq",sequenceName="achat_seq",allocationSize=1, initialValue = 1)
public class Achat   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateFacture ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Fournisseur fournisseur ;
    private EtatAchat etatAchat ;

    private List<AchatItem> achatItems ;
    private List<AvoirAchat> avoirs ;

    public Achat(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="achat_seq")
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
    public LocalDateTime getDateFacture(){
        return this.dateFacture;
    }
    public void setDateFacture(LocalDateTime dateFacture){
        this.dateFacture = dateFacture;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Fournisseur getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatAchat getEtatAchat(){
        return this.etatAchat;
    }
    public void setEtatAchat(EtatAchat etatAchat){
        this.etatAchat = etatAchat;
    }
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }
    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }
    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @OneToMany(mappedBy = "achat")

    public List<AchatItem> getAchatItems(){
        return this.achatItems;
    }
    public void setAchatItems(List<AchatItem> achatItems){
        this.achatItems = achatItems;
    }
    @OneToMany(mappedBy = "achat")

    public List<AvoirAchat> getAvoirs(){
        return this.avoirs;
    }
    public void setAvoirs(List<AvoirAchat> avoirs){
        this.avoirs = avoirs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Achat achat = (Achat) o;
        return id != null && id.equals(achat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

