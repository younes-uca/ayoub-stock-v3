package ma.zs.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.commun.EtatVente;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.commun.EtatVente;
import java.util.List;


@Repository
public interface EtatVenteDao extends AbstractRepository<EtatVente,Long>  {
    EtatVente findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatVente(item.id,item.libelle) FROM EtatVente item")
    List<EtatVente> findAllOptimized();

}
