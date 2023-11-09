package ma.zs.stocky.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.Produit;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProduitDao extends AbstractRepository<Produit,Long>  {

    List<Produit> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Produit> findByCategorieId(Long id);
    int deleteByCategorieId(Long id);
    long countByCategorieCode(String code);
    List<Produit> findByMarqueId(Long id);
    int deleteByMarqueId(Long id);
    long countByMarqueCode(String code);
    List<Produit> findByUniteMesureId(Long id);
    int deleteByUniteMesureId(Long id);
    long countByUniteMesureCode(String code);

    @Query("SELECT NEW Produit(item.id,item.reference) FROM Produit item")
    List<Produit> findAllOptimized();

}
