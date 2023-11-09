package  ma.zs.stocky.dao.specification.core.gestionchequeffet;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.TypeInstrumentCriteria;
import ma.zs.stocky.bean.core.gestionchequeffet.TypeInstrument;


public class TypeInstrumentSpecification extends  AbstractSpecification<TypeInstrumentCriteria, TypeInstrument>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public TypeInstrumentSpecification(TypeInstrumentCriteria criteria) {
        super(criteria);
    }

    public TypeInstrumentSpecification(TypeInstrumentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
