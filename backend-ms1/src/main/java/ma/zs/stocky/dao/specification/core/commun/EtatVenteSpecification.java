package  ma.zs.stocky.dao.specification.core.commun;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.stocky.bean.core.commun.EtatVente;


public class EtatVenteSpecification extends  AbstractSpecification<EtatVenteCriteria, EtatVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public EtatVenteSpecification(EtatVenteCriteria criteria) {
        super(criteria);
    }

    public EtatVenteSpecification(EtatVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
