package  ma.zs.stocky.dao.criteria.core.gestionchequeffet;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PermutationCriteria extends  BaseCriteria  {

    private LocalDateTime datePermutation;
    private LocalDateTime datePermutationFrom;
    private LocalDateTime datePermutationTo;
    private String description;
    private String descriptionLike;



    public PermutationCriteria(){}

    public LocalDateTime getDatePermutation(){
        return this.datePermutation;
    }
    public void setDatePermutation(LocalDateTime datePermutation){
        this.datePermutation = datePermutation;
    }
    public LocalDateTime getDatePermutationFrom(){
        return this.datePermutationFrom;
    }
    public void setDatePermutationFrom(LocalDateTime datePermutationFrom){
        this.datePermutationFrom = datePermutationFrom;
    }
    public LocalDateTime getDatePermutationTo(){
        return this.datePermutationTo;
    }
    public void setDatePermutationTo(LocalDateTime datePermutationTo){
        this.datePermutationTo = datePermutationTo;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


}
