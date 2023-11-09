package ma.zs.stocky.bean.core.stock;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "taux_tva")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="taux_tva_seq",sequenceName="taux_tva_seq",allocationSize=1, initialValue = 1)
public class TauxTva   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    private BigDecimal montant = BigDecimal.ZERO;
    @Column(length = 500)
    private String code;



    public TauxTva(){
        super();
    }

    public TauxTva(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TauxTva(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="taux_tva_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TauxTva tauxTva = (TauxTva) o;
        return id != null && id.equals(tauxTva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

