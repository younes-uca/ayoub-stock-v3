package ma.zs.stocky.dao.facade.core.paiement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.paiement.PaiementAvoirAchat;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.paiement.PaiementAvoirAchat;
import java.util.List;


@Repository
public interface PaiementAvoirAchatDao extends AbstractRepository<PaiementAvoirAchat,Long>  {
    PaiementAvoirAchat findByReference(String reference);
    int deleteByReference(String reference);

    List<PaiementAvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<PaiementAvoirAchat> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    long countByModePaiementCode(String code);
    List<PaiementAvoirAchat> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatId(Long id);

    @Query("SELECT NEW PaiementAvoirAchat(item.id,item.reference) FROM PaiementAvoirAchat item")
    List<PaiementAvoirAchat> findAllOptimized();

}
