package ma.zs.stocky.dao.facade.core.gestionchequeffet;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.gestionchequeffet.PermutationItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PermutationItemDao extends AbstractRepository<PermutationItem,Long>  {

    List<PermutationItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<PermutationItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);
    List<PermutationItem> findByPermutationId(Long id);
    int deleteByPermutationId(Long id);
    long countByPermutationId(Long id);


}
