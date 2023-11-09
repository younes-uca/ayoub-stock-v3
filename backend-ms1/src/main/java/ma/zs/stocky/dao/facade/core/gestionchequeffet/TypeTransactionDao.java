package ma.zs.stocky.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.gestionchequeffet.TypeTransaction;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.gestionchequeffet.TypeTransaction;
import java.util.List;


@Repository
public interface TypeTransactionDao extends AbstractRepository<TypeTransaction,Long>  {
    TypeTransaction findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeTransaction(item.id,item.libelle) FROM TypeTransaction item")
    List<TypeTransaction> findAllOptimized();

}
