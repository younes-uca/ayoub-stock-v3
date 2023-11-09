package ma.zs.stocky.dao.facade.core.entree;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.entree.SortieProduit;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.entree.SortieProduit;
import java.util.List;


@Repository
public interface SortieProduitDao extends AbstractRepository<SortieProduit,Long>  {
    SortieProduit findByReference(String reference);
    int deleteByReference(String reference);

    List<SortieProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);

    @Query("SELECT NEW SortieProduit(item.id,item.reference) FROM SortieProduit item")
    List<SortieProduit> findAllOptimized();

}
