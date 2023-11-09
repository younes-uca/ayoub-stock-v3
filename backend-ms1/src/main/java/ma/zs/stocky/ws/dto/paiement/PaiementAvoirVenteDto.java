package  ma.zs.stocky.ws.dto.paiement;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.commun.ModePaiementDto;
import ma.zs.stocky.ws.dto.stock.VenteDto;
import ma.zs.stocky.ws.dto.stock.AvoirVenteDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaiementAvoirVenteDto  extends AuditBaseDto {

    private String reference  ;
    private String datePaiement ;
    private BigDecimal montant  ;
    private String description  ;

    private VenteDto vente ;
    private ModePaiementDto modePaiement ;
    private AvoirVenteDto avoirVente ;



    public PaiementAvoirVenteDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(String datePaiement){
        this.datePaiement = datePaiement;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public VenteDto getVente(){
        return this.vente;
    }

    public void setVente(VenteDto vente){
        this.vente = vente;
    }
    public ModePaiementDto getModePaiement(){
        return this.modePaiement;
    }

    public void setModePaiement(ModePaiementDto modePaiement){
        this.modePaiement = modePaiement;
    }
    public AvoirVenteDto getAvoirVente(){
        return this.avoirVente;
    }

    public void setAvoirVente(AvoirVenteDto avoirVente){
        this.avoirVente = avoirVente;
    }






}
