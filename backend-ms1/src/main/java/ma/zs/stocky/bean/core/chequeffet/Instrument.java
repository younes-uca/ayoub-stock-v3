package ma.zs.stocky.bean.core.chequeffet;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.bean.core.gestionchequeffet.ChequeEffet;
import ma.zs.stocky.bean.core.gestionchequeffet.TypeInstrument;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "instrument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="instrument_seq",sequenceName="instrument_seq",allocationSize=1, initialValue = 1)
public class Instrument   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateEmission ;
    private BigDecimal montant = BigDecimal.ZERO;

    private TypeInstrument typeInstrument ;
    private ChequeEffet chequeEffet ;


    public Instrument(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="instrument_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypeInstrument getTypeInstrument(){
        return this.typeInstrument;
    }
    public void setTypeInstrument(TypeInstrument typeInstrument){
        this.typeInstrument = typeInstrument;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ChequeEffet getChequeEffet(){
        return this.chequeEffet;
    }
    public void setChequeEffet(ChequeEffet chequeEffet){
        this.chequeEffet = chequeEffet;
    }
    public LocalDateTime getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(LocalDateTime dateEmission){
        this.dateEmission = dateEmission;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument instrument = (Instrument) o;
        return id != null && id.equals(instrument.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

