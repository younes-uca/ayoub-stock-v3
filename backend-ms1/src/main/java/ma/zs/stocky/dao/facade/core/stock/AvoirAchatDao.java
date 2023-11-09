package ma.zs.stocky.dao.facade.core.stock;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.AvoirAchat;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AvoirAchatDao extends AbstractRepository<AvoirAchat,Long>  {

    List<AvoirAchat> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);


}
