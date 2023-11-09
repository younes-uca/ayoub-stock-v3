package ma.zs.stocky.dao.facade.core.gestionchequeffet;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.gestionchequeffet.ProprietaireBanque;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProprietaireBanqueDao extends AbstractRepository<ProprietaireBanque,Long>  {

    List<ProprietaireBanque> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireCode(String code);
    List<ProprietaireBanque> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueCode(String code);
    List<ProprietaireBanque> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);


}
