package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.stock.AvoirVenteItemCriteria;
import ma.zs.stocky.bean.core.stock.AvoirVenteItem;


public class AvoirVenteItemSpecification extends  AbstractSpecification<AvoirVenteItemCriteria, AvoirVenteItem>  {

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
        addPredicateFk("avoirVente","id", criteria.getAvoirVente()==null?null:criteria.getAvoirVente().getId());
        addPredicateFk("avoirVente","id", criteria.getAvoirVentes());
    }

    public AvoirVenteItemSpecification(AvoirVenteItemCriteria criteria) {
        super(criteria);
    }

    public AvoirVenteItemSpecification(AvoirVenteItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
