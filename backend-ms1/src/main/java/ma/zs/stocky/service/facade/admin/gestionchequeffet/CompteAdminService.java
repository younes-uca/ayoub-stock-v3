package ma.zs.stocky.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.stocky.bean.core.gestionchequeffet.Compte;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.CompteCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface CompteAdminService extends  IService<Compte,CompteCriteria>  {

    List<Compte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueCode(String code);
    List<Compte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireCode(String code);



}
