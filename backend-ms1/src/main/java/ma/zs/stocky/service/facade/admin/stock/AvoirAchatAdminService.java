package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.AvoirAchat;
import ma.zs.stocky.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface AvoirAchatAdminService extends  IService<AvoirAchat,AvoirAchatCriteria>  {

    List<AvoirAchat> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);



}
