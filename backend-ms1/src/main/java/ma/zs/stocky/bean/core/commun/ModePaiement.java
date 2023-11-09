package ma.zs.stocky.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "mode_paiement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="mode_paiement_seq",sequenceName="mode_paiement_seq",allocationSize=1, initialValue = 1)
public class ModePaiement   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;



    public ModePaiement(){
        super();
    }

    public ModePaiement(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public ModePaiement(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="mode_paiement_seq")
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
        ModePaiement modePaiement = (ModePaiement) o;
        return id != null && id.equals(modePaiement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

