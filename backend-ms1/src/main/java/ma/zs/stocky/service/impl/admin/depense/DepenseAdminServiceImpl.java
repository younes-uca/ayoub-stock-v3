package ma.zs.stocky.service.impl.admin.depense;


import ma.zs.stocky.bean.core.depense.Depense;
import ma.zs.stocky.dao.criteria.core.depense.DepenseCriteria;
import ma.zs.stocky.dao.facade.core.depense.DepenseDao;
import ma.zs.stocky.dao.specification.core.depense.DepenseSpecification;
import ma.zs.stocky.service.facade.admin.depense.DepenseAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class DepenseAdminServiceImpl extends AbstractServiceImpl<Depense, DepenseCriteria, DepenseDao> implements DepenseAdminService {












    public void configure() {
        super.configure(Depense.class, DepenseSpecification.class);
    }



    public DepenseAdminServiceImpl(DepenseDao dao) {
        super(dao);
    }

}
