package  ma.zs.stocky.ws.dto.stock;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.commun.DepotDto;
import ma.zs.stocky.ws.dto.commun.EntrepriseSocieteDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvoirVenteDto  extends AuditBaseDto {

    private String dateAvoir ;
    private BigDecimal montant  ;

    private EntrepriseSocieteDto entrepriseSociete ;
    private VenteDto vente ;

    private List<AvoirVenteItemDto> avoirVenteItems ;


    public AvoirVenteDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateAvoir(){
        return this.dateAvoir;
    }
    public void setDateAvoir(String dateAvoir){
        this.dateAvoir = dateAvoir;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    public EntrepriseSocieteDto getEntrepriseSociete(){
        return this.entrepriseSociete;
    }

    public void setEntrepriseSociete(EntrepriseSocieteDto entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public VenteDto getVente(){
        return this.vente;
    }

    public void setVente(VenteDto vente){
        this.vente = vente;
    }



    public List<AvoirVenteItemDto> getAvoirVenteItems(){
        return this.avoirVenteItems;
    }

    public void setAvoirVenteItems(List<AvoirVenteItemDto> avoirVenteItems){
        this.avoirVenteItems = avoirVenteItems;
    }



}
