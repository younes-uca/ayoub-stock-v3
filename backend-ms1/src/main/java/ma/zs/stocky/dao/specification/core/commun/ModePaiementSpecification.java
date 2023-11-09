package  ma.zs.stocky.dao.specification.core.commun;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.commun.ModePaiementCriteria;
import ma.zs.stocky.bean.core.commun.ModePaiement;


public class ModePaiementSpecification extends  AbstractSpecification<ModePaiementCriteria, ModePaiement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ModePaiementSpecification(ModePaiementCriteria criteria) {
        super(criteria);
    }

    public ModePaiementSpecification(ModePaiementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
