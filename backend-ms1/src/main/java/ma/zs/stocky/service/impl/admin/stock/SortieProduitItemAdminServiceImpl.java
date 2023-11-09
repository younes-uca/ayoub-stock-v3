package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.SortieProduitItem;
import ma.zs.stocky.dao.criteria.core.stock.SortieProduitItemCriteria;
import ma.zs.stocky.dao.facade.core.stock.SortieProduitItemDao;
import ma.zs.stocky.dao.specification.core.stock.SortieProduitItemSpecification;
import ma.zs.stocky.service.facade.admin.stock.SortieProduitItemAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.entree.SortieProduitAdminService ;
import ma.zs.stocky.bean.core.entree.SortieProduit ;
import ma.zs.stocky.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.stocky.bean.core.stock.Produit ;

import java.util.List;
@Service
public class SortieProduitItemAdminServiceImpl extends AbstractServiceImpl<SortieProduitItem, SortieProduitItemCriteria, SortieProduitItemDao> implements SortieProduitItemAdminService {






    public List<SortieProduitItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<SortieProduitItem> findBySortieProduitId(Long id){
        return dao.findBySortieProduitId(id);
    }
    public int deleteBySortieProduitId(Long id){
        return dao.deleteBySortieProduitId(id);
    }
    public long countBySortieProduitReference(String reference){
        return dao.countBySortieProduitReference(reference);
    }






    public void configure() {
        super.configure(SortieProduitItem.class, SortieProduitItemSpecification.class);
    }


    @Autowired
    private SortieProduitAdminService sortieProduitService ;
    @Autowired
    private ProduitAdminService produitService ;

    public SortieProduitItemAdminServiceImpl(SortieProduitItemDao dao) {
        super(dao);
    }

}
