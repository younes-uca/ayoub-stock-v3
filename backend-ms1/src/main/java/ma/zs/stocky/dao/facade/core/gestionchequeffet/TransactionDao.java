package ma.zs.stocky.dao.facade.core.gestionchequeffet;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.gestionchequeffet.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TransactionDao extends AbstractRepository<Transaction,Long>  {

    List<Transaction> findByTypeTransactionId(Long id);
    int deleteByTypeTransactionId(Long id);
    long countByTypeTransactionCode(String code);
    List<Transaction> findByInstrumentId(Long id);
    int deleteByInstrumentId(Long id);
    long countByInstrumentId(Long id);
    List<Transaction> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);


}
