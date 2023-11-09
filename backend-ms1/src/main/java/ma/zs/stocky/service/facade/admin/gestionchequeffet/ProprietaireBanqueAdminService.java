package ma.zs.stocky.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.stocky.bean.core.gestionchequeffet.ProprietaireBanque;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.ProprietaireBanqueCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface ProprietaireBanqueAdminService extends  IService<ProprietaireBanque,ProprietaireBanqueCriteria>  {

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
