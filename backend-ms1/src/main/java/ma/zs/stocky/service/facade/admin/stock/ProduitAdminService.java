package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.Produit;
import ma.zs.stocky.dao.criteria.core.stock.ProduitCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface ProduitAdminService extends  IService<Produit,ProduitCriteria>  {

    List<Produit> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Produit> findByCategorieId(Long id);
    int deleteByCategorieId(Long id);
    long countByCategorieCode(String code);
    List<Produit> findByMarqueId(Long id);
    int deleteByMarqueId(Long id);
    long countByMarqueCode(String code);
    List<Produit> findByUniteMesureId(Long id);
    int deleteByUniteMesureId(Long id);
    long countByUniteMesureCode(String code);



}
