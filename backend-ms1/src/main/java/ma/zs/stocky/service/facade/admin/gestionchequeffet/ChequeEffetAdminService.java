package ma.zs.stocky.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.stocky.bean.core.gestionchequeffet.ChequeEffet;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface ChequeEffetAdminService extends  IService<ChequeEffet,ChequeEffetCriteria>  {

    List<ChequeEffet> findByBeneficiaireId(Long id);
    int deleteByBeneficiaireId(Long id);
    long countByBeneficiaireId(Long id);



}
