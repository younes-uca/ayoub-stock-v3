package ma.zs.stocky.bean.core.stock;

import java.util.Objects;
import java.util.List;





import ma.zs.stocky.bean.core.commun.Client;
import ma.zs.stocky.bean.core.commun.Depot;
import ma.zs.stocky.bean.core.commun.EntrepriseSociete;
import ma.zs.stocky.bean.core.commun.EtatVente;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="vente_seq",sequenceName="vente_seq",allocationSize=1, initialValue = 1)
public class Vente   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String codeVente;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Client client ;
    private EtatVente etatVente ;

    private List<VenteItem> venteItems ;
    private List<AvoirVente> avoirs ;

    public Vente(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="vente_seq")
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
    public String getCodeVente(){
        return this.codeVente;
    }
    public void setCodeVente(String codeVente){
        this.codeVente = codeVente;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatVente getEtatVente(){
        return this.etatVente;
    }
    public void setEtatVente(EtatVente etatVente){
        this.etatVente = etatVente;
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
    @OneToMany(mappedBy = "vente")

    public List<VenteItem> getVenteItems(){
        return this.venteItems;
    }
    public void setVenteItems(List<VenteItem> venteItems){
        this.venteItems = venteItems;
    }
    @OneToMany(mappedBy = "vente")

    public List<AvoirVente> getAvoirs(){
        return this.avoirs;
    }
    public void setAvoirs(List<AvoirVente> avoirs){
        this.avoirs = avoirs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vente vente = (Vente) o;
        return id != null && id.equals(vente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

