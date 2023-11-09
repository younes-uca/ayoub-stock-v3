package  ma.zs.stocky.ws.dto.gestionchequeffet;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class PossedeCompteDto  extends AuditBaseDto {


    private ProprietaireDto proprietaire ;
    private BanqueDto banque ;
    private CompteDto compte ;



    public PossedeCompteDto(){
        super();
    }




    public ProprietaireDto getProprietaire(){
        return this.proprietaire;
    }

    public void setProprietaire(ProprietaireDto proprietaire){
        this.proprietaire = proprietaire;
    }
    public BanqueDto getBanque(){
        return this.banque;
    }

    public void setBanque(BanqueDto banque){
        this.banque = banque;
    }
    public CompteDto getCompte(){
        return this.compte;
    }

    public void setCompte(CompteDto compte){
        this.compte = compte;
    }






}
