package ma.zs.stocky.service.impl.admin.gestionchequeffet;


import ma.zs.stocky.bean.core.gestionchequeffet.Banque;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.BanqueCriteria;
import ma.zs.stocky.dao.facade.core.gestionchequeffet.BanqueDao;
import ma.zs.stocky.dao.specification.core.gestionchequeffet.BanqueSpecification;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.BanqueAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class BanqueAdminServiceImpl extends AbstractServiceImpl<Banque, BanqueCriteria, BanqueDao> implements BanqueAdminService {





    public Banque findByReferenceEntity(Banque t){
        return  dao.findByCode(t.getCode());
    }


    public List<Banque> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Banque.class, BanqueSpecification.class);
    }



    public BanqueAdminServiceImpl(BanqueDao dao) {
        super(dao);
    }

}
