package  ma.zs.stocky.dao.criteria.core.gestionchequeffet;


import ma.zs.stocky.dao.criteria.core.chequeffet.InstrumentCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class TransactionCriteria extends  BaseCriteria  {

    private LocalDateTime dateTransaction;
    private LocalDateTime dateTransactionFrom;
    private LocalDateTime dateTransactionTo;
    private LocalDateTime dateEncaissement;
    private LocalDateTime dateEncaissementFrom;
    private LocalDateTime dateEncaissementTo;
    private String pathCheque;
    private String pathChequeLike;
    private String description;
    private String descriptionLike;

    private TypeTransactionCriteria typeTransaction ;
    private List<TypeTransactionCriteria> typeTransactions ;
    private InstrumentCriteria instrument ;
    private List<InstrumentCriteria> instruments ;
    private CompteCriteria compte ;
    private List<CompteCriteria> comptes ;


    public TransactionCriteria(){}

    public LocalDateTime getDateTransaction(){
        return this.dateTransaction;
    }
    public void setDateTransaction(LocalDateTime dateTransaction){
        this.dateTransaction = dateTransaction;
    }
    public LocalDateTime getDateTransactionFrom(){
        return this.dateTransactionFrom;
    }
    public void setDateTransactionFrom(LocalDateTime dateTransactionFrom){
        this.dateTransactionFrom = dateTransactionFrom;
    }
    public LocalDateTime getDateTransactionTo(){
        return this.dateTransactionTo;
    }
    public void setDateTransactionTo(LocalDateTime dateTransactionTo){
        this.dateTransactionTo = dateTransactionTo;
    }
    public LocalDateTime getDateEncaissement(){
        return this.dateEncaissement;
    }
    public void setDateEncaissement(LocalDateTime dateEncaissement){
        this.dateEncaissement = dateEncaissement;
    }
    public LocalDateTime getDateEncaissementFrom(){
        return this.dateEncaissementFrom;
    }
    public void setDateEncaissementFrom(LocalDateTime dateEncaissementFrom){
        this.dateEncaissementFrom = dateEncaissementFrom;
    }
    public LocalDateTime getDateEncaissementTo(){
        return this.dateEncaissementTo;
    }
    public void setDateEncaissementTo(LocalDateTime dateEncaissementTo){
        this.dateEncaissementTo = dateEncaissementTo;
    }
    public String getPathCheque(){
        return this.pathCheque;
    }
    public void setPathCheque(String pathCheque){
        this.pathCheque = pathCheque;
    }
    public String getPathChequeLike(){
        return this.pathChequeLike;
    }
    public void setPathChequeLike(String pathChequeLike){
        this.pathChequeLike = pathChequeLike;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public TypeTransactionCriteria getTypeTransaction(){
        return this.typeTransaction;
    }

    public void setTypeTransaction(TypeTransactionCriteria typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    public List<TypeTransactionCriteria> getTypeTransactions(){
        return this.typeTransactions;
    }

    public void setTypeTransactions(List<TypeTransactionCriteria> typeTransactions){
        this.typeTransactions = typeTransactions;
    }
    public InstrumentCriteria getInstrument(){
        return this.instrument;
    }

    public void setInstrument(InstrumentCriteria instrument){
        this.instrument = instrument;
    }
    public List<InstrumentCriteria> getInstruments(){
        return this.instruments;
    }

    public void setInstruments(List<InstrumentCriteria> instruments){
        this.instruments = instruments;
    }
    public CompteCriteria getCompte(){
        return this.compte;
    }

    public void setCompte(CompteCriteria compte){
        this.compte = compte;
    }
    public List<CompteCriteria> getComptes(){
        return this.comptes;
    }

    public void setComptes(List<CompteCriteria> comptes){
        this.comptes = comptes;
    }
}
