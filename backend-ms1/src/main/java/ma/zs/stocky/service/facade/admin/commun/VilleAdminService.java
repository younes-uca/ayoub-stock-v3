package ma.zs.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zs.stocky.bean.core.commun.Ville;
import ma.zs.stocky.dao.criteria.core.commun.VilleCriteria;
import ma.zs.stocky.zynerator.service.IService;

import ma.zs.stocky.ws.dto.commun.VilleDto;
import org.springframework.http.HttpEntity;


public interface VilleAdminService extends  IService<Ville,VilleCriteria>  {



    HttpEntity<byte[]> createPdf(VilleDto dto) throws Exception;

}
