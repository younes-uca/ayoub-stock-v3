package  ma.zs.stocky.ws.dto.gestionchequeffet;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.ws.dto.chequeffet.InstrumentDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto  extends AuditBaseDto {

    private String dateTransaction ;
    private String dateEncaissement ;
    private String pathCheque  ;
    private String description  ;

    private TypeTransactionDto typeTransaction ;
    private InstrumentDto instrument ;
    private CompteDto compte ;



    public TransactionDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateTransaction(){
        return this.dateTransaction;
    }
    public void setDateTransaction(String dateTransaction){
        this.dateTransaction = dateTransaction;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateEncaissement(){
        return this.dateEncaissement;
    }
    public void setDateEncaissement(String dateEncaissement){
        this.dateEncaissement = dateEncaissement;
    }

    @Log
    public String getPathCheque(){
        return this.pathCheque;
    }
    public void setPathCheque(String pathCheque){
        this.pathCheque = pathCheque;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public TypeTransactionDto getTypeTransaction(){
        return this.typeTransaction;
    }

    public void setTypeTransaction(TypeTransactionDto typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    public InstrumentDto getInstrument(){
        return this.instrument;
    }

    public void setInstrument(InstrumentDto instrument){
        this.instrument = instrument;
    }
    public CompteDto getCompte(){
        return this.compte;
    }

    public void setCompte(CompteDto compte){
        this.compte = compte;
    }






}
