package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.Marque;
import ma.zs.stocky.dao.criteria.core.commun.MarqueCriteria;
import ma.zs.stocky.dao.facade.core.commun.MarqueDao;
import ma.zs.stocky.dao.specification.core.commun.MarqueSpecification;
import ma.zs.stocky.service.facade.admin.commun.MarqueAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class MarqueAdminServiceImpl extends AbstractServiceImpl<Marque, MarqueCriteria, MarqueDao> implements MarqueAdminService {





    public Marque findByReferenceEntity(Marque t){
        return  dao.findByCode(t.getCode());
    }


    public List<Marque> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Marque.class, MarqueSpecification.class);
    }



    public MarqueAdminServiceImpl(MarqueDao dao) {
        super(dao);
    }

}
