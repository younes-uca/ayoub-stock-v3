package  ma.zs.stocky.dao.specification.core.gestionchequeffet;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zs.stocky.bean.core.gestionchequeffet.Proprietaire;


public class ProprietaireSpecification extends  AbstractSpecification<ProprietaireCriteria, Proprietaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ProprietaireSpecification(ProprietaireCriteria criteria) {
        super(criteria);
    }

    public ProprietaireSpecification(ProprietaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
