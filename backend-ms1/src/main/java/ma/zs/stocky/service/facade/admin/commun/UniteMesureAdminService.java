package ma.zs.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zs.stocky.bean.core.commun.UniteMesure;
import ma.zs.stocky.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zs.stocky.zynerator.service.IService;

import ma.zs.stocky.ws.dto.commun.UniteMesureDto;
import org.springframework.http.HttpEntity;


public interface UniteMesureAdminService extends  IService<UniteMesure,UniteMesureCriteria>  {



    HttpEntity<byte[]> createPdf(UniteMesureDto dto) throws Exception;

}
