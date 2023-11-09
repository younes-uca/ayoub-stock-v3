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
import ma.zs.stocky.ws.dto.stock.AchatDto;
import ma.zs.stocky.ws.dto.stock.AvoirAchatDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaiementAvoirAchatDto  extends AuditBaseDto {

    private String reference  ;
    private String datePaiement ;
    private BigDecimal montant  ;
    private String description  ;

    private AchatDto achat ;
    private ModePaiementDto modePaiement ;
    private AvoirAchatDto avoirAchat ;



    public PaiementAvoirAchatDto(){
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


    public AchatDto getAchat(){
        return this.achat;
    }

    public void setAchat(AchatDto achat){
        this.achat = achat;
    }
    public ModePaiementDto getModePaiement(){
        return this.modePaiement;
    }

    public void setModePaiement(ModePaiementDto modePaiement){
        this.modePaiement = modePaiement;
    }
    public AvoirAchatDto getAvoirAchat(){
        return this.avoirAchat;
    }

    public void setAvoirAchat(AvoirAchatDto avoirAchat){
        this.avoirAchat = avoirAchat;
    }






}
