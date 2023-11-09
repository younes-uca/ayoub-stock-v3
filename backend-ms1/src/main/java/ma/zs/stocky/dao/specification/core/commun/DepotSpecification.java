package  ma.zs.stocky.dao.specification.core.commun;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.commun.DepotCriteria;
import ma.zs.stocky.bean.core.commun.Depot;


public class DepotSpecification extends  AbstractSpecification<DepotCriteria, Depot>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("adresse", criteria.getAdresse(),criteria.getAdresseLike());
    }

    public DepotSpecification(DepotCriteria criteria) {
        super(criteria);
    }

    public DepotSpecification(DepotCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
