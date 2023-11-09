package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.CommandeItem;
import ma.zs.stocky.dao.criteria.core.stock.CommandeItemCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface CommandeItemAdminService extends  IService<CommandeItem,CommandeItemCriteria>  {

    List<CommandeItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<CommandeItem> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    long countByCommandeId(Long id);



}
