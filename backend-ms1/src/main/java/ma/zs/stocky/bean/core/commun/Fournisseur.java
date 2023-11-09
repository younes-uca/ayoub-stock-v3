package ma.zs.stocky.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "fournisseur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="fournisseur_seq",sequenceName="fournisseur_seq",allocationSize=1, initialValue = 1)
public class Fournisseur   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String ice;
    @Column(length = 500)
    private String telephone;
    @Column(length = 500)
    private String infoBancaire;
    @Column(length = 500)
    private String adresse;
    private BigDecimal creance = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Ville ville ;


    public Fournisseur(){
        super();
    }

    public Fournisseur(Long id,String ice){
        this.id = id;
        this.ice = ice ;
    }
    public Fournisseur(String ice){
        this.ice = ice ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="fournisseur_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public String getInfoBancaire(){
        return this.infoBancaire;
    }
    public void setInfoBancaire(String infoBancaire){
        this.infoBancaire = infoBancaire;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Ville getVille(){
        return this.ville;
    }
    public void setVille(Ville ville){
        this.ville = ville;
    }
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public BigDecimal getCreance(){
        return this.creance;
    }
    public void setCreance(BigDecimal creance){
        this.creance = creance;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Transient
    public String getLabel() {
        label = ice;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fournisseur fournisseur = (Fournisseur) o;
        return id != null && id.equals(fournisseur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

