package ma.zs.stocky.service.impl.admin.gestionchequeffet;


import ma.zs.stocky.bean.core.gestionchequeffet.Proprietaire;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zs.stocky.dao.facade.core.gestionchequeffet.ProprietaireDao;
import ma.zs.stocky.dao.specification.core.gestionchequeffet.ProprietaireSpecification;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.ProprietaireAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ProprietaireAdminServiceImpl extends AbstractServiceImpl<Proprietaire, ProprietaireCriteria, ProprietaireDao> implements ProprietaireAdminService {





    public Proprietaire findByReferenceEntity(Proprietaire t){
        return  dao.findByCode(t.getCode());
    }


    public List<Proprietaire> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Proprietaire.class, ProprietaireSpecification.class);
    }



    public ProprietaireAdminServiceImpl(ProprietaireDao dao) {
        super(dao);
    }

}
