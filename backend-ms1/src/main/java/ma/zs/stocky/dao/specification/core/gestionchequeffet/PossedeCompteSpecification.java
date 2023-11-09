package  ma.zs.stocky.dao.specification.core.gestionchequeffet;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.PossedeCompteCriteria;
import ma.zs.stocky.bean.core.gestionchequeffet.PossedeCompte;


public class PossedeCompteSpecification extends  AbstractSpecification<PossedeCompteCriteria, PossedeCompte>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("proprietaire","id", criteria.getProprietaire()==null?null:criteria.getProprietaire().getId());
        addPredicateFk("proprietaire","id", criteria.getProprietaires());
        addPredicateFk("proprietaire","code", criteria.getProprietaire()==null?null:criteria.getProprietaire().getCode());
        addPredicateFk("banque","id", criteria.getBanque()==null?null:criteria.getBanque().getId());
        addPredicateFk("banque","id", criteria.getBanques());
        addPredicateFk("banque","code", criteria.getBanque()==null?null:criteria.getBanque().getCode());
        addPredicateFk("compte","id", criteria.getCompte()==null?null:criteria.getCompte().getId());
        addPredicateFk("compte","id", criteria.getComptes());
    }

    public PossedeCompteSpecification(PossedeCompteCriteria criteria) {
        super(criteria);
    }

    public PossedeCompteSpecification(PossedeCompteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
