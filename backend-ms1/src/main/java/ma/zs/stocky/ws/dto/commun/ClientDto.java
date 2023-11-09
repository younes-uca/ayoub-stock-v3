package  ma.zs.stocky.ws.dto.commun;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto  extends AuditBaseDto {

    private String cin  ;
    private String nom  ;
    private String prenom  ;
    private String telephone  ;
    private String adresse  ;
    private String description  ;
    private BigDecimal creance  ;




    public ClientDto(){
        super();
    }



    @Log
    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }

    @Log
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    @Log
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    @Log
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    @Log
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public BigDecimal getCreance(){
        return this.creance;
    }
    public void setCreance(BigDecimal creance){
        this.creance = creance;
    }








}
