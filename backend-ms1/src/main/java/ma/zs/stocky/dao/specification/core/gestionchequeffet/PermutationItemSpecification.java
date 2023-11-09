package  ma.zs.stocky.dao.specification.core.gestionchequeffet;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.PermutationItemCriteria;
import ma.zs.stocky.bean.core.gestionchequeffet.PermutationItem;


public class PermutationItemSpecification extends  AbstractSpecification<PermutationItemCriteria, PermutationItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
        addPredicateFk("depot","code", criteria.getDepot()==null?null:criteria.getDepot().getCode());
        addPredicateFk("permutation","id", criteria.getPermutation()==null?null:criteria.getPermutation().getId());
        addPredicateFk("permutation","id", criteria.getPermutations());
    }

    public PermutationItemSpecification(PermutationItemCriteria criteria) {
        super(criteria);
    }

    public PermutationItemSpecification(PermutationItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
