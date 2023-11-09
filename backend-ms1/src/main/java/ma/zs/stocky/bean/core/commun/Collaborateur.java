package ma.zs.stocky.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "collaborateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="collaborateur_seq",sequenceName="collaborateur_seq",allocationSize=1, initialValue = 1)
public class Collaborateur   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;



    public Collaborateur(){
        super();
    }

    public Collaborateur(Long id,String nom){
        this.id = id;
        this.nom = nom ;
    }
    public Collaborateur(String nom){
        this.nom = nom ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="collaborateur_seq")
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
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    @Transient
    public String getLabel() {
        label = nom;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborateur collaborateur = (Collaborateur) o;
        return id != null && id.equals(collaborateur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

