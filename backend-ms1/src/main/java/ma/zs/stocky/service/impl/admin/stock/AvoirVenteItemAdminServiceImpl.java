package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.AvoirVenteItem;
import ma.zs.stocky.dao.criteria.core.stock.AvoirVenteItemCriteria;
import ma.zs.stocky.dao.facade.core.stock.AvoirVenteItemDao;
import ma.zs.stocky.dao.specification.core.stock.AvoirVenteItemSpecification;
import ma.zs.stocky.service.facade.admin.stock.AvoirVenteItemAdminService;
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
import ma.zs.stocky.service.facade.admin.stock.AvoirVenteAdminService ;
import ma.zs.stocky.bean.core.stock.AvoirVente ;

import java.util.List;
@Service
public class AvoirVenteItemAdminServiceImpl extends AbstractServiceImpl<AvoirVenteItem, AvoirVenteItemCriteria, AvoirVenteItemDao> implements AvoirVenteItemAdminService {






    public List<AvoirVenteItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<AvoirVenteItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotCode(String code){
        return dao.countByDepotCode(code);
    }
    public List<AvoirVenteItem> findByAvoirVenteId(Long id){
        return dao.findByAvoirVenteId(id);
    }
    public int deleteByAvoirVenteId(Long id){
        return dao.deleteByAvoirVenteId(id);
    }
    public long countByAvoirVenteId(Long id){
        return dao.countByAvoirVenteId(id);
    }






    public void configure() {
        super.configure(AvoirVenteItem.class, AvoirVenteItemSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private AvoirVenteAdminService avoirVenteService ;

    public AvoirVenteItemAdminServiceImpl(AvoirVenteItemDao dao) {
        super(dao);
    }

}
