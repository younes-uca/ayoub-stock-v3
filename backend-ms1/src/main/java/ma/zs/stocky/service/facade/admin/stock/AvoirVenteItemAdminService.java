package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.AvoirVenteItem;
import ma.zs.stocky.dao.criteria.core.stock.AvoirVenteItemCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface AvoirVenteItemAdminService extends  IService<AvoirVenteItem,AvoirVenteItemCriteria>  {

    List<AvoirVenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<AvoirVenteItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);
    List<AvoirVenteItem> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteId(Long id);



}
