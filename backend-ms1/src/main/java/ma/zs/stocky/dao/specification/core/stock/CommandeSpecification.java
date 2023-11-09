package  ma.zs.stocky.dao.specification.core.stock;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.stock.CommandeCriteria;
import ma.zs.stocky.bean.core.stock.Commande;


public class CommandeSpecification extends  AbstractSpecification<CommandeCriteria, Commande>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("etatCommande","id", criteria.getEtatCommande()==null?null:criteria.getEtatCommande().getId());
        addPredicateFk("etatCommande","id", criteria.getEtatCommandes());
        addPredicateFk("etatCommande","code", criteria.getEtatCommande()==null?null:criteria.getEtatCommande().getCode());
    }

    public CommandeSpecification(CommandeCriteria criteria) {
        super(criteria);
    }

    public CommandeSpecification(CommandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
