package ma.zs.stocky.service.impl.admin.gestionchequeffet;


import ma.zs.stocky.bean.core.gestionchequeffet.Transaction;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.TransactionCriteria;
import ma.zs.stocky.dao.facade.core.gestionchequeffet.TransactionDao;
import ma.zs.stocky.dao.specification.core.gestionchequeffet.TransactionSpecification;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.TransactionAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.gestionchequeffet.TypeTransactionAdminService ;
import ma.zs.stocky.bean.core.gestionchequeffet.TypeTransaction ;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.CompteAdminService ;
import ma.zs.stocky.bean.core.gestionchequeffet.Compte ;
import ma.zs.stocky.service.facade.admin.chequeffet.InstrumentAdminService ;
import ma.zs.stocky.bean.core.chequeffet.Instrument ;

import java.util.List;
@Service
public class TransactionAdminServiceImpl extends AbstractServiceImpl<Transaction, TransactionCriteria, TransactionDao> implements TransactionAdminService {






    public List<Transaction> findByTypeTransactionId(Long id){
        return dao.findByTypeTransactionId(id);
    }
    public int deleteByTypeTransactionId(Long id){
        return dao.deleteByTypeTransactionId(id);
    }
    public long countByTypeTransactionCode(String code){
        return dao.countByTypeTransactionCode(code);
    }
    public List<Transaction> findByInstrumentId(Long id){
        return dao.findByInstrumentId(id);
    }
    public int deleteByInstrumentId(Long id){
        return dao.deleteByInstrumentId(id);
    }
    public long countByInstrumentId(Long id){
        return dao.countByInstrumentId(id);
    }
    public List<Transaction> findByCompteId(Long id){
        return dao.findByCompteId(id);
    }
    public int deleteByCompteId(Long id){
        return dao.deleteByCompteId(id);
    }
    public long countByCompteId(Long id){
        return dao.countByCompteId(id);
    }






    public void configure() {
        super.configure(Transaction.class, TransactionSpecification.class);
    }


    @Autowired
    private TypeTransactionAdminService typeTransactionService ;
    @Autowired
    private CompteAdminService compteService ;
    @Autowired
    private InstrumentAdminService instrumentService ;

    public TransactionAdminServiceImpl(TransactionDao dao) {
        super(dao);
    }

}
