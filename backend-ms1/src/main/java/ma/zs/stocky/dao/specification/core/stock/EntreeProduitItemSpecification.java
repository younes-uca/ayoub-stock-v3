package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.stock.EntreeProduitItemCriteria;
import ma.zs.stocky.bean.core.stock.EntreeProduitItem;


public class EntreeProduitItemSpecification extends  AbstractSpecification<EntreeProduitItemCriteria, EntreeProduitItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("entreeProduit","id", criteria.getEntreeProduit()==null?null:criteria.getEntreeProduit().getId());
        addPredicateFk("entreeProduit","id", criteria.getEntreeProduits());
        addPredicateFk("entreeProduit","reference", criteria.getEntreeProduit()==null?null:criteria.getEntreeProduit().getReference());
    }

    public EntreeProduitItemSpecification(EntreeProduitItemCriteria criteria) {
        super(criteria);
    }

    public EntreeProduitItemSpecification(EntreeProduitItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
