package ma.zs.stocky.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.gestionchequeffet.Compte;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CompteDao extends AbstractRepository<Compte,Long>  {

    List<Compte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueCode(String code);
    List<Compte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireCode(String code);

    @Query("SELECT NEW Compte(item.id,item.numeroCompte) FROM Compte item")
    List<Compte> findAllOptimized();

}
