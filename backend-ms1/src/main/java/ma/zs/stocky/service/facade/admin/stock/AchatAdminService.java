package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.Achat;
import ma.zs.stocky.dao.criteria.core.stock.AchatCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface AchatAdminService extends  IService<Achat,AchatCriteria>  {

    List<Achat> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Achat> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurId(Long id);
    List<Achat> findByEtatAchatId(Long id);
    int deleteByEtatAchatId(Long id);
    long countByEtatAchatCode(String code);



}
