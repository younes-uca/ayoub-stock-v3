package ma.zs.stocky.dao.facade.core.stock;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.AvoirVenteItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AvoirVenteItemDao extends AbstractRepository<AvoirVenteItem,Long>  {

    List<AvoirVenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<AvoirVenteItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);
    List<AvoirVenteItem> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteId(Long id);


}
