package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zs.stocky.bean.core.stock.AvoirAchat;


public class AvoirAchatSpecification extends  AbstractSpecification<AvoirAchatCriteria, AvoirAchat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateAvoir", criteria.getDateAvoir(), criteria.getDateAvoirFrom(), criteria.getDateAvoirTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("achat","id", criteria.getAchat()==null?null:criteria.getAchat().getId());
        addPredicateFk("achat","id", criteria.getAchats());
    }

    public AvoirAchatSpecification(AvoirAchatCriteria criteria) {
        super(criteria);
    }

    public AvoirAchatSpecification(AvoirAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
