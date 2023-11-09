package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.Vente;
import ma.zs.stocky.dao.criteria.core.stock.VenteCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface VenteAdminService extends  IService<Vente,VenteCriteria>  {

    List<Vente> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Vente> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientId(Long id);
    List<Vente> findByEtatVenteId(Long id);
    int deleteByEtatVenteId(Long id);
    long countByEtatVenteCode(String code);



}
