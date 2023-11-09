package  ma.zs.stocky.dao.specification.core.entree;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zs.stocky.bean.core.entree.EntreeProduit;


public class EntreeProduitSpecification extends  AbstractSpecification<EntreeProduitCriteria, EntreeProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateEntreeProduit", criteria.getDateEntreeProduit(), criteria.getDateEntreeProduitFrom(), criteria.getDateEntreeProduitTo());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
        addPredicateFk("depot","code", criteria.getDepot()==null?null:criteria.getDepot().getCode());
    }

    public EntreeProduitSpecification(EntreeProduitCriteria criteria) {
        super(criteria);
    }

    public EntreeProduitSpecification(EntreeProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
