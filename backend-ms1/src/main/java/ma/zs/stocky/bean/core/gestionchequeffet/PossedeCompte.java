package ma.zs.stocky.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "possede_compte")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="possede_compte_seq",sequenceName="possede_compte_seq",allocationSize=1, initialValue = 1)
public class PossedeCompte   extends AuditBusinessObject     {

    private Long id;


    private Proprietaire proprietaire ;
    private Banque banque ;
    private Compte compte ;


    public PossedeCompte(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="possede_compte_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Proprietaire getProprietaire(){
        return this.proprietaire;
    }
    public void setProprietaire(Proprietaire proprietaire){
        this.proprietaire = proprietaire;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Banque getBanque(){
        return this.banque;
    }
    public void setBanque(Banque banque){
        this.banque = banque;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Compte getCompte(){
        return this.compte;
    }
    public void setCompte(Compte compte){
        this.compte = compte;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PossedeCompte possedeCompte = (PossedeCompte) o;
        return id != null && id.equals(possedeCompte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

