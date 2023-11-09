package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.Inventaire;
import ma.zs.stocky.dao.criteria.core.stock.InventaireCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface InventaireAdminService extends  IService<Inventaire,InventaireCriteria>  {

    List<Inventaire> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);



}
