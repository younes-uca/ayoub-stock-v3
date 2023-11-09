package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.Categorie;
import ma.zs.stocky.dao.criteria.core.commun.CategorieCriteria;
import ma.zs.stocky.dao.facade.core.commun.CategorieDao;
import ma.zs.stocky.dao.specification.core.commun.CategorieSpecification;
import ma.zs.stocky.service.facade.admin.commun.CategorieAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategorieAdminServiceImpl extends AbstractServiceImpl<Categorie, CategorieCriteria, CategorieDao> implements CategorieAdminService {





    public Categorie findByReferenceEntity(Categorie t){
        return  dao.findByCode(t.getCode());
    }


    public List<Categorie> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Categorie.class, CategorieSpecification.class);
    }



    public CategorieAdminServiceImpl(CategorieDao dao) {
        super(dao);
    }

}
