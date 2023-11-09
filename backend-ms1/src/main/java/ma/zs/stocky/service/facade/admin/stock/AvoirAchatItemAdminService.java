package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.AvoirAchatItem;
import ma.zs.stocky.dao.criteria.core.stock.AvoirAchatItemCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface AvoirAchatItemAdminService extends  IService<AvoirAchatItem,AvoirAchatItemCriteria>  {

    List<AvoirAchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<AvoirAchatItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);
    List<AvoirAchatItem> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatId(Long id);



}
