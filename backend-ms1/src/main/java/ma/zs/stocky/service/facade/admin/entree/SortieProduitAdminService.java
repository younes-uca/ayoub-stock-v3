package ma.zs.stocky.service.facade.admin.entree;

import java.util.List;
import ma.zs.stocky.bean.core.entree.SortieProduit;
import ma.zs.stocky.dao.criteria.core.entree.SortieProduitCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface SortieProduitAdminService extends  IService<SortieProduit,SortieProduitCriteria>  {

    List<SortieProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);



}
