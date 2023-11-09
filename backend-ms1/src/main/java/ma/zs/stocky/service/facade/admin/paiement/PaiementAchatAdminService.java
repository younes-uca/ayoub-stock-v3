package ma.zs.stocky.service.facade.admin.paiement;

import java.util.List;
import ma.zs.stocky.bean.core.paiement.PaiementAchat;
import ma.zs.stocky.dao.criteria.core.paiement.PaiementAchatCriteria;
import ma.zs.stocky.zynerator.service.IService;

import ma.zs.stocky.ws.dto.paiement.PaiementAchatDto;
import org.springframework.http.HttpEntity;


public interface PaiementAchatAdminService extends  IService<PaiementAchat,PaiementAchatCriteria>  {

    List<PaiementAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<PaiementAchat> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    long countByModePaiementCode(String code);


    HttpEntity<byte[]> createPdf(PaiementAchatDto dto) throws Exception;

}
