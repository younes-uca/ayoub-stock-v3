package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.stock.AvoirVenteCriteria;
import ma.zs.stocky.bean.core.stock.AvoirVente;


public class AvoirVenteSpecification extends  AbstractSpecification<AvoirVenteCriteria, AvoirVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateAvoir", criteria.getDateAvoir(), criteria.getDateAvoirFrom(), criteria.getDateAvoirTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("vente","id", criteria.getVente()==null?null:criteria.getVente().getId());
        addPredicateFk("vente","id", criteria.getVentes());
    }

    public AvoirVenteSpecification(AvoirVenteCriteria criteria) {
        super(criteria);
    }

    public AvoirVenteSpecification(AvoirVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
