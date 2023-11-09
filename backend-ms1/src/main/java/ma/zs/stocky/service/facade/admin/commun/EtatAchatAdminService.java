package ma.zs.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zs.stocky.bean.core.commun.EtatAchat;
import ma.zs.stocky.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zs.stocky.zynerator.service.IService;

import ma.zs.stocky.ws.dto.commun.EtatAchatDto;
import org.springframework.http.HttpEntity;


public interface EtatAchatAdminService extends  IService<EtatAchat,EtatAchatCriteria>  {



    HttpEntity<byte[]> createPdf(EtatAchatDto dto) throws Exception;

}
