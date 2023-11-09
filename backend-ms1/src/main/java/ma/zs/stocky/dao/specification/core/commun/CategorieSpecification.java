package  ma.zs.stocky.dao.specification.core.commun;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.commun.CategorieCriteria;
import ma.zs.stocky.bean.core.commun.Categorie;


public class CategorieSpecification extends  AbstractSpecification<CategorieCriteria, Categorie>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public CategorieSpecification(CategorieCriteria criteria) {
        super(criteria);
    }

    public CategorieSpecification(CategorieCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
