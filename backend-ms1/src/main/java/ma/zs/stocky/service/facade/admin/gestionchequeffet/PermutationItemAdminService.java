package ma.zs.stocky.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.stocky.bean.core.gestionchequeffet.PermutationItem;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.PermutationItemCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface PermutationItemAdminService extends  IService<PermutationItem,PermutationItemCriteria>  {

    List<PermutationItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<PermutationItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);
    List<PermutationItem> findByPermutationId(Long id);
    int deleteByPermutationId(Long id);
    long countByPermutationId(Long id);



}
