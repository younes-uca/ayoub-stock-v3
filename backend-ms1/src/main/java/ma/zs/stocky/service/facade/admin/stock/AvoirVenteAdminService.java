package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.AvoirVente;
import ma.zs.stocky.dao.criteria.core.stock.AvoirVenteCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface AvoirVenteAdminService extends  IService<AvoirVente,AvoirVenteCriteria>  {

    List<AvoirVente> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);



}
