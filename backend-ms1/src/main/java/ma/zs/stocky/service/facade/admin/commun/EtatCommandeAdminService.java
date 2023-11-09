package ma.zs.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zs.stocky.bean.core.commun.EtatCommande;
import ma.zs.stocky.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zs.stocky.zynerator.service.IService;

import ma.zs.stocky.ws.dto.commun.EtatCommandeDto;
import org.springframework.http.HttpEntity;


public interface EtatCommandeAdminService extends  IService<EtatCommande,EtatCommandeCriteria>  {



    HttpEntity<byte[]> createPdf(EtatCommandeDto dto) throws Exception;

}
