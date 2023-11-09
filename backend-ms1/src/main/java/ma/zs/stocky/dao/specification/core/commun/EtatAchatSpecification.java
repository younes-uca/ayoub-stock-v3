package  ma.zs.stocky.dao.specification.core.commun;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zs.stocky.bean.core.commun.EtatAchat;


public class EtatAchatSpecification extends  AbstractSpecification<EtatAchatCriteria, EtatAchat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public EtatAchatSpecification(EtatAchatCriteria criteria) {
        super(criteria);
    }

    public EtatAchatSpecification(EtatAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
