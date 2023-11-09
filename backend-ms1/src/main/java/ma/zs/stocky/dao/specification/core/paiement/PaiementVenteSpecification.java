package  ma.zs.stocky.dao.specification.core.paiement;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.paiement.PaiementVenteCriteria;
import ma.zs.stocky.bean.core.paiement.PaiementVente;


public class PaiementVenteSpecification extends  AbstractSpecification<PaiementVenteCriteria, PaiementVente>  {

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
    }

    public PaiementVenteSpecification(PaiementVenteCriteria criteria) {
        super(criteria);
    }

    public PaiementVenteSpecification(PaiementVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
