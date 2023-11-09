package ma.zs.stocky.service.facade.admin.paiement;

import java.util.List;
import ma.zs.stocky.bean.core.paiement.PaiementAvoirVente;
import ma.zs.stocky.dao.criteria.core.paiement.PaiementAvoirVenteCriteria;
import ma.zs.stocky.zynerator.service.IService;

import ma.zs.stocky.ws.dto.paiement.PaiementAvoirVenteDto;
import org.springframework.http.HttpEntity;


public interface PaiementAvoirVenteAdminService extends  IService<PaiementAvoirVente,PaiementAvoirVenteCriteria>  {

    List<PaiementAvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);
    List<PaiementAvoirVente> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    long countByModePaiementCode(String code);
    List<PaiementAvoirVente> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteId(Long id);


    HttpEntity<byte[]> createPdf(PaiementAvoirVenteDto dto) throws Exception;

}
