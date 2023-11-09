package  ma.zs.stocky.dao.specification.core.chequeffet;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.chequeffet.InstrumentCriteria;
import ma.zs.stocky.bean.core.chequeffet.Instrument;


public class InstrumentSpecification extends  AbstractSpecification<InstrumentCriteria, Instrument>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateEmission", criteria.getDateEmission(), criteria.getDateEmissionFrom(), criteria.getDateEmissionTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("typeInstrument","id", criteria.getTypeInstrument()==null?null:criteria.getTypeInstrument().getId());
        addPredicateFk("typeInstrument","id", criteria.getTypeInstruments());
        addPredicateFk("typeInstrument","code", criteria.getTypeInstrument()==null?null:criteria.getTypeInstrument().getCode());
        addPredicateFk("chequeEffet","id", criteria.getChequeEffet()==null?null:criteria.getChequeEffet().getId());
        addPredicateFk("chequeEffet","id", criteria.getChequeEffets());
    }

    public InstrumentSpecification(InstrumentCriteria criteria) {
        super(criteria);
    }

    public InstrumentSpecification(InstrumentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
