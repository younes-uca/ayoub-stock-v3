package ma.zs.stocky.dao.facade.core.paiement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.paiement.PaiementVente;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.paiement.PaiementVente;
import java.util.List;


@Repository
public interface PaiementVenteDao extends AbstractRepository<PaiementVente,Long>  {
    PaiementVente findByReference(String reference);
    int deleteByReference(String reference);

    List<PaiementVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);
    List<PaiementVente> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    long countByModePaiementCode(String code);

    @Query("SELECT NEW PaiementVente(item.id,item.reference) FROM PaiementVente item")
    List<PaiementVente> findAllOptimized();

}
