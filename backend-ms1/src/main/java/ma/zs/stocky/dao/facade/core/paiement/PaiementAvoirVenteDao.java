package ma.zs.stocky.dao.facade.core.paiement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.paiement.PaiementAvoirVente;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.paiement.PaiementAvoirVente;
import java.util.List;


@Repository
public interface PaiementAvoirVenteDao extends AbstractRepository<PaiementAvoirVente,Long>  {
    PaiementAvoirVente findByReference(String reference);
    int deleteByReference(String reference);

    List<PaiementAvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);
    List<PaiementAvoirVente> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    long countByModePaiementCode(String code);
    List<PaiementAvoirVente> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteId(Long id);

    @Query("SELECT NEW PaiementAvoirVente(item.id,item.reference) FROM PaiementAvoirVente item")
    List<PaiementAvoirVente> findAllOptimized();

}
