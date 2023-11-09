package  ma.zs.stocky.ws.dto.stock;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.commun.DepotDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvoirAchatItemDto  extends AuditBaseDto {

    private BigDecimal montantAvoir  ;
    private BigDecimal quantite  ;

    private ProduitDto produit ;
    private DepotDto depot ;
    private AvoirAchatDto avoirAchat ;



    public AvoirAchatItemDto(){
        super();
    }



    @Log
    public BigDecimal getMontantAvoir(){
        return this.montantAvoir;
    }
    public void setMontantAvoir(BigDecimal montantAvoir){
        this.montantAvoir = montantAvoir;
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
    public AvoirAchatDto getAvoirAchat(){
        return this.avoirAchat;
    }

    public void setAvoirAchat(AvoirAchatDto avoirAchat){
        this.avoirAchat = avoirAchat;
    }






}
