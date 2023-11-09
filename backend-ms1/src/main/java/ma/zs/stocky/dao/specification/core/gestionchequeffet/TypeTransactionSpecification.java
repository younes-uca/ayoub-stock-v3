package  ma.zs.stocky.dao.specification.core.gestionchequeffet;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.TypeTransactionCriteria;
import ma.zs.stocky.bean.core.gestionchequeffet.TypeTransaction;


public class TypeTransactionSpecification extends  AbstractSpecification<TypeTransactionCriteria, TypeTransaction>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public TypeTransactionSpecification(TypeTransactionCriteria criteria) {
        super(criteria);
    }

    public TypeTransactionSpecification(TypeTransactionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
