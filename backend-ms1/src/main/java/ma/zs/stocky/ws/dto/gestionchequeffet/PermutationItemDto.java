package  ma.zs.stocky.ws.dto.gestionchequeffet;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.commun.DepotDto;
import ma.zs.stocky.ws.dto.stock.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermutationItemDto  extends AuditBaseDto {

    private BigDecimal quantite  ;

    private ProduitDto produit ;
    private DepotDto depot ;
    private PermutationDto permutation ;



    public PermutationItemDto(){
        super();
    }



    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public DepotDto getDepot(){
        return this.depot;
    }

    public void setDepot(DepotDto depot){
        this.depot = depot;
    }
    public PermutationDto getPermutation(){
        return this.permutation;
    }

    public void setPermutation(PermutationDto permutation){
        this.permutation = permutation;
    }






}
