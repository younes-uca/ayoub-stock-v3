package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.VenteItem;
import ma.zs.stocky.dao.criteria.core.stock.VenteItemCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface VenteItemAdminService extends  IService<VenteItem,VenteItemCriteria>  {

    List<VenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<VenteItem> findByTauxTvaId(Long id);
    int deleteByTauxTvaId(Long id);
    long countByTauxTvaCode(String code);
    List<VenteItem> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);
    List<VenteItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);



}
