package  ma.zs.stocky.ws.dto.gestionchequeffet;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.ws.dto.commun.DepotDto;
import ma.zs.stocky.ws.dto.stock.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermutationDto  extends AuditBaseDto {

    private String datePermutation ;
    private String description  ;


    private List<PermutationItemDto> permutationItems ;


    public PermutationDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePermutation(){
        return this.datePermutation;
    }
    public void setDatePermutation(String datePermutation){
        this.datePermutation = datePermutation;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }





    public List<PermutationItemDto> getPermutationItems(){
        return this.permutationItems;
    }

    public void setPermutationItems(List<PermutationItemDto> permutationItems){
        this.permutationItems = permutationItems;
    }



}
