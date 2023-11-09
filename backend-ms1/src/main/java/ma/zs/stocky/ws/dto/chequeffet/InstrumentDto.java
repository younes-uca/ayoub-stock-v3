package  ma.zs.stocky.ws.dto.chequeffet;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.stocky.ws.dto.gestionchequeffet.ChequeEffetDto;
import ma.zs.stocky.ws.dto.gestionchequeffet.TypeInstrumentDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstrumentDto  extends AuditBaseDto {

    private String dateEmission ;
    private BigDecimal montant  ;

    private TypeInstrumentDto typeInstrument ;
    private ChequeEffetDto chequeEffet ;



    public InstrumentDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(String dateEmission){
        this.dateEmission = dateEmission;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    public TypeInstrumentDto getTypeInstrument(){
        return this.typeInstrument;
    }

    public void setTypeInstrument(TypeInstrumentDto typeInstrument){
        this.typeInstrument = typeInstrument;
    }
    public ChequeEffetDto getChequeEffet(){
        return this.chequeEffet;
    }

    public void setChequeEffet(ChequeEffetDto chequeEffet){
        this.chequeEffet = chequeEffet;
    }






}
