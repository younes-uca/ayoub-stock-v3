package ma.zs.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zs.stocky.bean.core.commun.ModePaiement;
import ma.zs.stocky.dao.criteria.core.commun.ModePaiementCriteria;
import ma.zs.stocky.zynerator.service.IService;

import ma.zs.stocky.ws.dto.commun.ModePaiementDto;
import org.springframework.http.HttpEntity;


public interface ModePaiementAdminService extends  IService<ModePaiement,ModePaiementCriteria>  {



    HttpEntity<byte[]> createPdf(ModePaiementDto dto) throws Exception;

}
