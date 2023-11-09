package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.stock.TauxTvaCriteria;
import ma.zs.stocky.bean.core.stock.TauxTva;


public class TauxTvaSpecification extends  AbstractSpecification<TauxTvaCriteria, TauxTva>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public TauxTvaSpecification(TauxTvaCriteria criteria) {
        super(criteria);
    }

    public TauxTvaSpecification(TauxTvaCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
