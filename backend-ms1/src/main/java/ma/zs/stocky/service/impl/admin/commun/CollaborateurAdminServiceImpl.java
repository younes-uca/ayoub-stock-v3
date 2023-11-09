package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.Collaborateur;
import ma.zs.stocky.dao.criteria.core.commun.CollaborateurCriteria;
import ma.zs.stocky.dao.facade.core.commun.CollaborateurDao;
import ma.zs.stocky.dao.specification.core.commun.CollaborateurSpecification;
import ma.zs.stocky.service.facade.admin.commun.CollaborateurAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CollaborateurAdminServiceImpl extends AbstractServiceImpl<Collaborateur, CollaborateurCriteria, CollaborateurDao> implements CollaborateurAdminService {







    public List<Collaborateur> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Collaborateur.class, CollaborateurSpecification.class);
    }



    public CollaborateurAdminServiceImpl(CollaborateurDao dao) {
        super(dao);
    }

}
