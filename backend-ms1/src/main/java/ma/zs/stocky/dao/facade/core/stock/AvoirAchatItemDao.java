package ma.zs.stocky.dao.facade.core.stock;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.AvoirAchatItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AvoirAchatItemDao extends AbstractRepository<AvoirAchatItem,Long>  {

    List<AvoirAchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<AvoirAchatItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);
    List<AvoirAchatItem> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatId(Long id);


}
