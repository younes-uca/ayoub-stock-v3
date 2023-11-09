package  ma.zs.stocky.dao.criteria.core.gestionchequeffet;


import ma.zs.stocky.dao.criteria.core.commun.FournisseurCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ChequeEffetCriteria extends  BaseCriteria  {

    private String numeroChequeEffet;
    private String numeroChequeEffetLike;
    private LocalDateTime dateEmission;
    private LocalDateTime dateEmissionFrom;
    private LocalDateTime dateEmissionTo;
    private String montant;
    private String montantMin;
    private String montantMax;

    private FournisseurCriteria beneficiaire ;
    private List<FournisseurCriteria> beneficiaires ;


    public ChequeEffetCriteria(){}

    public String getNumeroChequeEffet(){
        return this.numeroChequeEffet;
    }
    public void setNumeroChequeEffet(String numeroChequeEffet){
        this.numeroChequeEffet = numeroChequeEffet;
    }
    public String getNumeroChequeEffetLike(){
        return this.numeroChequeEffetLike;
    }
    public void setNumeroChequeEffetLike(String numeroChequeEffetLike){
        this.numeroChequeEffetLike = numeroChequeEffetLike;
    }

    public LocalDateTime getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(LocalDateTime dateEmission){
        this.dateEmission = dateEmission;
    }
    public LocalDateTime getDateEmissionFrom(){
        return this.dateEmissionFrom;
    }
    public void setDateEmissionFrom(LocalDateTime dateEmissionFrom){
        this.dateEmissionFrom = dateEmissionFrom;
    }
    public LocalDateTime getDateEmissionTo(){
        return this.dateEmissionTo;
    }
    public void setDateEmissionTo(LocalDateTime dateEmissionTo){
        this.dateEmissionTo = dateEmissionTo;
    }
    public String getMontant(){
        return this.montant;
    }
    public void setMontant(String montant){
        this.montant = montant;
    }   
    public String getMontantMin(){
        return this.montantMin;
    }
    public void setMontantMin(String montantMin){
        this.montantMin = montantMin;
    }
    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
    }
      

    public FournisseurCriteria getBeneficiaire(){
        return this.beneficiaire;
    }

    public void setBeneficiaire(FournisseurCriteria beneficiaire){
        this.beneficiaire = beneficiaire;
    }
    public List<FournisseurCriteria> getBeneficiaires(){
        return this.beneficiaires;
    }

    public void setBeneficiaires(List<FournisseurCriteria> beneficiaires){
        this.beneficiaires = beneficiaires;
    }
}
