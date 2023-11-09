package  ma.zs.stocky.dao.specification.core.entree;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.entree.SortieProduitCriteria;
import ma.zs.stocky.bean.core.entree.SortieProduit;


public class SortieProduitSpecification extends  AbstractSpecification<SortieProduitCriteria, SortieProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateSortieProduit", criteria.getDateSortieProduit(), criteria.getDateSortieProduitFrom(), criteria.getDateSortieProduitTo());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
        addPredicateFk("depot","code", criteria.getDepot()==null?null:criteria.getDepot().getCode());
    }

    public SortieProduitSpecification(SortieProduitCriteria criteria) {
        super(criteria);
    }

    public SortieProduitSpecification(SortieProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
