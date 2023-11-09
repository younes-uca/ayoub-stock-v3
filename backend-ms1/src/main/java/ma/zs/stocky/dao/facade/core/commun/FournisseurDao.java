package ma.zs.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.commun.Fournisseur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FournisseurDao extends AbstractRepository<Fournisseur,Long>  {

    List<Fournisseur> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    long countByVilleId(Long id);

    @Query("SELECT NEW Fournisseur(item.id,item.ice) FROM Fournisseur item")
    List<Fournisseur> findAllOptimized();

}
