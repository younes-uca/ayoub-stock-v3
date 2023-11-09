package ma.zs.stocky.dao.facade.core.stock;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.InventaireItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface InventaireItemDao extends AbstractRepository<InventaireItem,Long>  {

    List<InventaireItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<InventaireItem> findByInventaireId(Long id);
    int deleteByInventaireId(Long id);
    long countByInventaireReference(String reference);


}
