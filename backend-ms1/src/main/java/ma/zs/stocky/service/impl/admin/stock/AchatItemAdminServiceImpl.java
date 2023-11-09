package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.AchatItem;
import ma.zs.stocky.dao.criteria.core.stock.AchatItemCriteria;
import ma.zs.stocky.dao.facade.core.stock.AchatItemDao;
import ma.zs.stocky.dao.specification.core.stock.AchatItemSpecification;
import ma.zs.stocky.service.facade.admin.stock.AchatItemAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.commun.DepotAdminService ;
import ma.zs.stocky.bean.core.commun.Depot ;
import ma.zs.stocky.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.stocky.bean.core.stock.Produit ;
import ma.zs.stocky.service.facade.admin.stock.AchatAdminService ;
import ma.zs.stocky.bean.core.stock.Achat ;

import java.util.List;
@Service
public class AchatItemAdminServiceImpl extends AbstractServiceImpl<AchatItem, AchatItemCriteria, AchatItemDao> implements AchatItemAdminService {






    public List<AchatItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<AchatItem> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }
    public List<AchatItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotCode(String code){
        return dao.countByDepotCode(code);
    }






    public void configure() {
        super.configure(AchatItem.class, AchatItemSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private AchatAdminService achatService ;

    public AchatItemAdminServiceImpl(AchatItemDao dao) {
        super(dao);
    }

}
