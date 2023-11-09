package  ma.zs.stocky.dao.criteria.core.chequeffet;


import ma.zs.stocky.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.TypeInstrumentCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class InstrumentCriteria extends  BaseCriteria  {

    private LocalDateTime dateEmission;
    private LocalDateTime dateEmissionFrom;
    private LocalDateTime dateEmissionTo;
    private String montant;
    private String montantMin;
    private String montantMax;

    private TypeInstrumentCriteria typeInstrument ;
    private List<TypeInstrumentCriteria> typeInstruments ;
    private ChequeEffetCriteria chequeEffet ;
    private List<ChequeEffetCriteria> chequeEffets ;


    public InstrumentCriteria(){}

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
      

    public TypeInstrumentCriteria getTypeInstrument(){
        return this.typeInstrument;
    }

    public void setTypeInstrument(TypeInstrumentCriteria typeInstrument){
        this.typeInstrument = typeInstrument;
    }
    public List<TypeInstrumentCriteria> getTypeInstruments(){
        return this.typeInstruments;
    }

    public void setTypeInstruments(List<TypeInstrumentCriteria> typeInstruments){
        this.typeInstruments = typeInstruments;
    }
    public ChequeEffetCriteria getChequeEffet(){
        return this.chequeEffet;
    }

    public void setChequeEffet(ChequeEffetCriteria chequeEffet){
        this.chequeEffet = chequeEffet;
    }
    public List<ChequeEffetCriteria> getChequeEffets(){
        return this.chequeEffets;
    }

    public void setChequeEffets(List<ChequeEffetCriteria> chequeEffets){
        this.chequeEffets = chequeEffets;
    }
}
