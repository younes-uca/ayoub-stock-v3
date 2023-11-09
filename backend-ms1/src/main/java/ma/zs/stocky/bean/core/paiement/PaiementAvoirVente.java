package ma.zs.stocky.bean.core.paiement;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.commun.ModePaiement;
import ma.zs.stocky.bean.core.stock.Vente;
import ma.zs.stocky.bean.core.stock.AvoirVente;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "paiement_avoir_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_avoir_vente_seq",sequenceName="paiement_avoir_vente_seq",allocationSize=1, initialValue = 1)
public class PaiementAvoirVente   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime datePaiement ;
    private BigDecimal montant = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Vente vente ;
    private ModePaiement modePaiement ;
    private AvoirVente avoirVente ;


    public PaiementAvoirVente(){
        super();
    }

    public PaiementAvoirVente(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public PaiementAvoirVente(String reference){
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="paiement_avoir_vente_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Vente getVente(){
        return this.vente;
    }
    public void setVente(Vente vente){
        this.vente = vente;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ModePaiement getModePaiement(){
        return this.modePaiement;
    }
    public void setModePaiement(ModePaiement modePaiement){
        this.modePaiement = modePaiement;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public AvoirVente getAvoirVente(){
        return this.avoirVente;
    }
    public void setAvoirVente(AvoirVente avoirVente){
        this.avoirVente = avoirVente;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaiementAvoirVente paiementAvoirVente = (PaiementAvoirVente) o;
        return id != null && id.equals(paiementAvoirVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

