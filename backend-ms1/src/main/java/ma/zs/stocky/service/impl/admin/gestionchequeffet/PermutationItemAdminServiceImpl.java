package ma.zs.stocky.service.impl.admin.gestionchequeffet;


import ma.zs.stocky.bean.core.gestionchequeffet.PermutationItem;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.PermutationItemCriteria;
import ma.zs.stocky.dao.facade.core.gestionchequeffet.PermutationItemDao;
import ma.zs.stocky.dao.specification.core.gestionchequeffet.PermutationItemSpecification;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.PermutationItemAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.commun.DepotAdminService ;
import ma.zs.stocky.bean.core.commun.Depot ;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.PermutationAdminService ;
import ma.zs.stocky.bean.core.gestionchequeffet.Permutation ;
import ma.zs.stocky.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.stocky.bean.core.stock.Produit ;

import java.util.List;
@Service
public class PermutationItemAdminServiceImpl extends AbstractServiceImpl<PermutationItem, PermutationItemCriteria, PermutationItemDao> implements PermutationItemAdminService {






    public List<PermutationItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<PermutationItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotCode(String code){
        return dao.countByDepotCode(code);
    }
    public List<PermutationItem> findByPermutationId(Long id){
        return dao.findByPermutationId(id);
    }
    public int deleteByPermutationId(Long id){
        return dao.deleteByPermutationId(id);
    }
    public long countByPermutationId(Long id){
        return dao.countByPermutationId(id);
    }






    public void configure() {
        super.configure(PermutationItem.class, PermutationItemSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private PermutationAdminService permutationService ;
    @Autowired
    private ProduitAdminService produitService ;

    public PermutationItemAdminServiceImpl(PermutationItemDao dao) {
        super(dao);
    }

}
