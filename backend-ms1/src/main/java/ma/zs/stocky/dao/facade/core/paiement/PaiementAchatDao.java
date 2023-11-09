package ma.zs.stocky.dao.facade.core.paiement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.paiement.PaiementAchat;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.paiement.PaiementAchat;
import java.util.List;


@Repository
public interface PaiementAchatDao extends AbstractRepository<PaiementAchat,Long>  {
    PaiementAchat findByReference(String reference);
    int deleteByReference(String reference);

    List<PaiementAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<PaiementAchat> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    long countByModePaiementCode(String code);

    @Query("SELECT NEW PaiementAchat(item.id,item.reference) FROM PaiementAchat item")
    List<PaiementAchat> findAllOptimized();

}
