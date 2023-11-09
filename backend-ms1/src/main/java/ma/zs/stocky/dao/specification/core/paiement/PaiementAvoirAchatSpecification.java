package  ma.zs.stocky.dao.specification.core.paiement;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.paiement.PaiementAvoirAchatCriteria;
import ma.zs.stocky.bean.core.paiement.PaiementAvoirAchat;


public class PaiementAvoirAchatSpecification extends  AbstractSpecification<PaiementAvoirAchatCriteria, PaiementAvoirAchat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("achat","id", criteria.getAchat()==null?null:criteria.getAchat().getId());
        addPredicateFk("achat","id", criteria.getAchats());
        addPredicateFk("modePaiement","id", criteria.getModePaiement()==null?null:criteria.getModePaiement().getId());
        addPredicateFk("modePaiement","id", criteria.getModePaiements());
        addPredicateFk("modePaiement","code", criteria.getModePaiement()==null?null:criteria.getModePaiement().getCode());
        addPredicateFk("avoirAchat","id", criteria.getAvoirAchat()==null?null:criteria.getAvoirAchat().getId());
        addPredicateFk("avoirAchat","id", criteria.getAvoirAchats());
    }

    public PaiementAvoirAchatSpecification(PaiementAvoirAchatCriteria criteria) {
        super(criteria);
    }

    public PaiementAvoirAchatSpecification(PaiementAvoirAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
