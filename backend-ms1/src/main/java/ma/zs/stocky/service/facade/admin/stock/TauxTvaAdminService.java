package ma.zs.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zs.stocky.bean.core.stock.TauxTva;
import ma.zs.stocky.dao.criteria.core.stock.TauxTvaCriteria;
import ma.zs.stocky.zynerator.service.IService;

import ma.zs.stocky.ws.dto.stock.TauxTvaDto;
import org.springframework.http.HttpEntity;


public interface TauxTvaAdminService extends  IService<TauxTva,TauxTvaCriteria>  {



    HttpEntity<byte[]> createPdf(TauxTvaDto dto) throws Exception;

}
