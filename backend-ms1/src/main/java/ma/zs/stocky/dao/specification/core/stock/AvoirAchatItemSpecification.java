package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.stock.AvoirAchatItemCriteria;
import ma.zs.stocky.bean.core.stock.AvoirAchatItem;


public class AvoirAchatItemSpecification extends  AbstractSpecification<AvoirAchatItemCriteria, AvoirAchatItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("montantAvoir", criteria.getMontantAvoir(), criteria.getMontantAvoirMin(), criteria.getMontantAvoirMax());
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
        addPredicateFk("depot","code", criteria.getDepot()==null?null:criteria.getDepot().getCode());
        addPredicateFk("avoirAchat","id", criteria.getAvoirAchat()==null?null:criteria.getAvoirAchat().getId());
        addPredicateFk("avoirAchat","id", criteria.getAvoirAchats());
    }

    public AvoirAchatItemSpecification(AvoirAchatItemCriteria criteria) {
        super(criteria);
    }

    public AvoirAchatItemSpecification(AvoirAchatItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
