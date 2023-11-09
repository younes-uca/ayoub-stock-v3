package  ma.zs.stocky.dao.specification.core.gestionchequeffet;

import ma.zs.stocky.zynerator.specification.AbstractSpecification;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.TransactionCriteria;
import ma.zs.stocky.bean.core.gestionchequeffet.Transaction;


public class TransactionSpecification extends  AbstractSpecification<TransactionCriteria, Transaction>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateTransaction", criteria.getDateTransaction(), criteria.getDateTransactionFrom(), criteria.getDateTransactionTo());
        addPredicate("dateEncaissement", criteria.getDateEncaissement(), criteria.getDateEncaissementFrom(), criteria.getDateEncaissementTo());
        addPredicate("pathCheque", criteria.getPathCheque(),criteria.getPathChequeLike());
        addPredicateFk("typeTransaction","id", criteria.getTypeTransaction()==null?null:criteria.getTypeTransaction().getId());
        addPredicateFk("typeTransaction","id", criteria.getTypeTransactions());
        addPredicateFk("typeTransaction","code", criteria.getTypeTransaction()==null?null:criteria.getTypeTransaction().getCode());
        addPredicateFk("instrument","id", criteria.getInstrument()==null?null:criteria.getInstrument().getId());
        addPredicateFk("instrument","id", criteria.getInstruments());
        addPredicateFk("compte","id", criteria.getCompte()==null?null:criteria.getCompte().getId());
        addPredicateFk("compte","id", criteria.getComptes());
    }

    public TransactionSpecification(TransactionCriteria criteria) {
        super(criteria);
    }

    public TransactionSpecification(TransactionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
