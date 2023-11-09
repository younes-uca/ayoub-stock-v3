package ma.zs.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zs.stocky.bean.core.commun.EtatVente;
import ma.zs.stocky.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.stocky.zynerator.service.IService;

import ma.zs.stocky.ws.dto.commun.EtatVenteDto;
import org.springframework.http.HttpEntity;


public interface EtatVenteAdminService extends  IService<EtatVente,EtatVenteCriteria>  {



    HttpEntity<byte[]> createPdf(EtatVenteDto dto) throws Exception;

}
