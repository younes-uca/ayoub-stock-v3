package ma.zs.stocky.dao.facade.core.gestionchequeffet;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.gestionchequeffet.PossedeCompte;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PossedeCompteDao extends AbstractRepository<PossedeCompte,Long>  {

    List<PossedeCompte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireCode(String code);
    List<PossedeCompte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueCode(String code);
    List<PossedeCompte> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);


}
