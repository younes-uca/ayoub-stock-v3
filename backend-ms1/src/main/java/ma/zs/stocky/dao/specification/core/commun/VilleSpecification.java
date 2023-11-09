package  ma.zs.stocky.dao.specification.core.commun;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.commun.VilleCriteria;
import ma.zs.stocky.bean.core.commun.Ville;


public class VilleSpecification extends  AbstractSpecification<VilleCriteria, Ville>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public VilleSpecification(VilleCriteria criteria) {
        super(criteria);
    }

    public VilleSpecification(VilleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
