package ma.zs.stocky.bean.core.gestionchequeffet;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.commun.Depot;
import ma.zs.stocky.bean.core.stock.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "permutation")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="permutation_seq",sequenceName="permutation_seq",allocationSize=1, initialValue = 1)
public class Permutation   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime datePermutation ;
    @Column(length = 500)
    private String description;


    private List<PermutationItem> permutationItems ;

    public Permutation(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="permutation_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDatePermutation(){
        return this.datePermutation;
    }
    public void setDatePermutation(LocalDateTime datePermutation){
        this.datePermutation = datePermutation;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @OneToMany(mappedBy = "permutation")

    public List<PermutationItem> getPermutationItems(){
        return this.permutationItems;
    }
    public void setPermutationItems(List<PermutationItem> permutationItems){
        this.permutationItems = permutationItems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permutation permutation = (Permutation) o;
        return id != null && id.equals(permutation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

