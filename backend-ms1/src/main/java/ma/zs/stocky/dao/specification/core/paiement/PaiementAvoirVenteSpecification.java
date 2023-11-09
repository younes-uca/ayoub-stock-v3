package  ma.zs.stocky.dao.specification.core.paiement;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.paiement.PaiementAvoirVenteCriteria;
import ma.zs.stocky.bean.core.paiement.PaiementAvoirVente;


public class PaiementAvoirVenteSpecification extends  AbstractSpecification<PaiementAvoirVenteCriteria, PaiementAvoirVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("vente","id", criteria.getVente()==null?null:criteria.getVente().getId());
        addPredicateFk("vente","id", criteria.getVentes());
        addPredicateFk("modePaiement","id", criteria.getModePaiement()==null?null:criteria.getModePaiement().getId());
        addPredicateFk("modePaiement","id", criteria.getModePaiements());
        addPredicateFk("modePaiement","code", criteria.getModePaiement()==null?null:criteria.getModePaiement().getCode());
        addPredicateFk("avoirVente","id", criteria.getAvoirVente()==null?null:criteria.getAvoirVente().getId());
        addPredicateFk("avoirVente","id", criteria.getAvoirVentes());
    }

    public PaiementAvoirVenteSpecification(PaiementAvoirVenteCriteria criteria) {
        super(criteria);
    }

    public PaiementAvoirVenteSpecification(PaiementAvoirVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
