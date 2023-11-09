package ma.zs.stocky.dao.facade.core.stock;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.VenteItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface VenteItemDao extends AbstractRepository<VenteItem,Long>  {

    List<VenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<VenteItem> findByTauxTvaId(Long id);
    int deleteByTauxTvaId(Long id);
    long countByTauxTvaCode(String code);
    List<VenteItem> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);
    List<VenteItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);


}
