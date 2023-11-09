package  ma.zs.stocky.dao.specification.core.commun;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zs.stocky.bean.core.commun.EntrepriseSociete;


public class EntrepriseSocieteSpecification extends  AbstractSpecification<EntrepriseSocieteCriteria, EntrepriseSociete>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
        addPredicateBigDecimal("capital", criteria.getCapital(), criteria.getCapitalMin(), criteria.getCapitalMax());
    }

    public EntrepriseSocieteSpecification(EntrepriseSocieteCriteria criteria) {
        super(criteria);
    }

    public EntrepriseSocieteSpecification(EntrepriseSocieteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
