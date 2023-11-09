package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.stock.InventaireItemCriteria;
import ma.zs.stocky.bean.core.stock.InventaireItem;


public class InventaireItemSpecification extends  AbstractSpecification<InventaireItemCriteria, InventaireItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantiteEstime", criteria.getQuantiteEstime(), criteria.getQuantiteEstimeMin(), criteria.getQuantiteEstimeMax());
        addPredicateBigDecimal("quantiteReelle", criteria.getQuantiteReelle(), criteria.getQuantiteReelleMin(), criteria.getQuantiteReelleMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("inventaire","id", criteria.getInventaire()==null?null:criteria.getInventaire().getId());
        addPredicateFk("inventaire","id", criteria.getInventaires());
        addPredicateFk("inventaire","reference", criteria.getInventaire()==null?null:criteria.getInventaire().getReference());
    }

    public InventaireItemSpecification(InventaireItemCriteria criteria) {
        super(criteria);
    }

    public InventaireItemSpecification(InventaireItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
