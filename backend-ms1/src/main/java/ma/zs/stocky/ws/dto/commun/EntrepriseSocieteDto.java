package  ma.zs.stocky.ws.dto.commun;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntrepriseSocieteDto  extends AuditBaseDto {

    private String nom  ;
    private String ice  ;
    private BigDecimal capital  ;




    public EntrepriseSocieteDto(){
        super();
    }



    @Log
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    @Log
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }

    @Log
    public BigDecimal getCapital(){
        return this.capital;
    }
    public void setCapital(BigDecimal capital){
        this.capital = capital;
    }








}
