package  ma.zs.stocky.ws.dto.stock;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.commun.ClientDto;
import ma.zs.stocky.ws.dto.commun.DepotDto;
import ma.zs.stocky.ws.dto.commun.EntrepriseSocieteDto;
import ma.zs.stocky.ws.dto.commun.EtatVenteDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class VenteDto  extends AuditBaseDto {

    private String codeVente  ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTva  ;
    private BigDecimal montantTtc  ;
    private String description  ;

    private EntrepriseSocieteDto entrepriseSociete ;
    private ClientDto client ;
    private EtatVenteDto etatVente ;

    private List<VenteItemDto> venteItems ;
    private List<AvoirVenteDto> avoirs ;


    public VenteDto(){
        super();
    }



    @Log
    public String getCodeVente(){
        return this.codeVente;
    }
    public void setCodeVente(String codeVente){
        this.codeVente = codeVente;
    }

    @Log
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }

    @Log
    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }

    @Log
    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public EntrepriseSocieteDto getEntrepriseSociete(){
        return this.entrepriseSociete;
    }

    public void setEntrepriseSociete(EntrepriseSocieteDto entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public EtatVenteDto getEtatVente(){
        return this.etatVente;
    }

    public void setEtatVente(EtatVenteDto etatVente){
        this.etatVente = etatVente;
    }



    public List<VenteItemDto> getVenteItems(){
        return this.venteItems;
    }

    public void setVenteItems(List<VenteItemDto> venteItems){
        this.venteItems = venteItems;
    }
    public List<AvoirVenteDto> getAvoirs(){
        return this.avoirs;
    }

    public void setAvoirs(List<AvoirVenteDto> avoirs){
        this.avoirs = avoirs;
    }



}
