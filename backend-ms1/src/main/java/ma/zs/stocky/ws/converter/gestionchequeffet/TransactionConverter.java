package  ma.zs.stocky.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.gestionchequeffet.TypeTransactionConverter;
import ma.zs.stocky.ws.converter.gestionchequeffet.CompteConverter;
import ma.zs.stocky.ws.converter.chequeffet.InstrumentConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.gestionchequeffet.Transaction;
import ma.zs.stocky.ws.dto.gestionchequeffet.TransactionDto;

@Component
public class TransactionConverter extends AbstractConverter<Transaction, TransactionDto> {

    @Autowired
    private TypeTransactionConverter typeTransactionConverter ;
    @Autowired
    private CompteConverter compteConverter ;
    @Autowired
    private InstrumentConverter instrumentConverter ;
    private boolean typeTransaction;
    private boolean instrument;
    private boolean compte;

    public  TransactionConverter(){
        super(Transaction.class, TransactionDto.class);
    }

    @Override
    public Transaction toItem(TransactionDto dto) {
        if (dto == null) {
            return null;
        } else {
        Transaction item = new Transaction();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateTransaction()))
                item.setDateTransaction(DateUtil.stringEnToDate(dto.getDateTransaction()));
            if(StringUtil.isNotEmpty(dto.getDateEncaissement()))
                item.setDateEncaissement(DateUtil.stringEnToDate(dto.getDateEncaissement()));
            if(StringUtil.isNotEmpty(dto.getPathCheque()))
                item.setPathCheque(dto.getPathCheque());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.typeTransaction && dto.getTypeTransaction()!=null &&  dto.getTypeTransaction().getId() != null)
                item.setTypeTransaction(typeTransactionConverter.toItem(dto.getTypeTransaction())) ;

            if(this.instrument && dto.getInstrument()!=null &&  dto.getInstrument().getId() != null)
                item.setInstrument(instrumentConverter.toItem(dto.getInstrument())) ;

            if(this.compte && dto.getCompte()!=null &&  dto.getCompte().getId() != null)
                item.setCompte(compteConverter.toItem(dto.getCompte())) ;




        return item;
        }
    }

    @Override
    public TransactionDto toDto(Transaction item) {
        if (item == null) {
            return null;
        } else {
            TransactionDto dto = new TransactionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateTransaction()!=null)
                dto.setDateTransaction(DateUtil.dateTimeToString(item.getDateTransaction()));
            if(item.getDateEncaissement()!=null)
                dto.setDateEncaissement(DateUtil.dateTimeToString(item.getDateEncaissement()));
            if(StringUtil.isNotEmpty(item.getPathCheque()))
                dto.setPathCheque(item.getPathCheque());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.typeTransaction && item.getTypeTransaction()!=null) {
            dto.setTypeTransaction(typeTransactionConverter.toDto(item.getTypeTransaction())) ;
        }
        if(this.instrument && item.getInstrument()!=null) {
            dto.setInstrument(instrumentConverter.toDto(item.getInstrument())) ;
        }
        if(this.compte && item.getCompte()!=null) {
            dto.setCompte(compteConverter.toDto(item.getCompte())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.typeTransaction = value;
        this.instrument = value;
        this.compte = value;
    }


    public TypeTransactionConverter getTypeTransactionConverter(){
        return this.typeTransactionConverter;
    }
    public void setTypeTransactionConverter(TypeTransactionConverter typeTransactionConverter ){
        this.typeTransactionConverter = typeTransactionConverter;
    }
    public CompteConverter getCompteConverter(){
        return this.compteConverter;
    }
    public void setCompteConverter(CompteConverter compteConverter ){
        this.compteConverter = compteConverter;
    }
    public InstrumentConverter getInstrumentConverter(){
        return this.instrumentConverter;
    }
    public void setInstrumentConverter(InstrumentConverter instrumentConverter ){
        this.instrumentConverter = instrumentConverter;
    }
    public boolean  isTypeTransaction(){
        return this.typeTransaction;
    }
    public void  setTypeTransaction(boolean typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    public boolean  isInstrument(){
        return this.instrument;
    }
    public void  setInstrument(boolean instrument){
        this.instrument = instrument;
    }
    public boolean  isCompte(){
        return this.compte;
    }
    public void  setCompte(boolean compte){
        this.compte = compte;
    }
}
