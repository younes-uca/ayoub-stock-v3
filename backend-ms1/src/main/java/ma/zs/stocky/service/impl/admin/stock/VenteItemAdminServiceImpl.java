package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.VenteItem;
import ma.zs.stocky.dao.criteria.core.stock.VenteItemCriteria;
import ma.zs.stocky.dao.facade.core.stock.VenteItemDao;
import ma.zs.stocky.dao.specification.core.stock.VenteItemSpecification;
import ma.zs.stocky.service.facade.admin.stock.VenteItemAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.commun.DepotAdminService ;
import ma.zs.stocky.bean.core.commun.Depot ;
import ma.zs.stocky.service.facade.admin.stock.TauxTvaAdminService ;
import ma.zs.stocky.bean.core.stock.TauxTva ;
import ma.zs.stocky.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.stocky.bean.core.stock.Produit ;
import ma.zs.stocky.service.facade.admin.stock.VenteAdminService ;
import ma.zs.stocky.bean.core.stock.Vente ;

import java.util.List;
@Service
public class VenteItemAdminServiceImpl extends AbstractServiceImpl<VenteItem, VenteItemCriteria, VenteItemDao> implements VenteItemAdminService {






    public List<VenteItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<VenteItem> findByTauxTvaId(Long id){
        return dao.findByTauxTvaId(id);
    }
    public int deleteByTauxTvaId(Long id){
        return dao.deleteByTauxTvaId(id);
    }
    public long countByTauxTvaCode(String code){
        return dao.countByTauxTvaCode(code);
    }
    public List<VenteItem> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public long countByVenteId(Long id){
        return dao.countByVenteId(id);
    }
    public List<VenteItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotCode(String code){
        return dao.countByDepotCode(code);
    }






    public void configure() {
        super.configure(VenteItem.class, VenteItemSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private TauxTvaAdminService tauxTvaService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private VenteAdminService venteService ;

    public VenteItemAdminServiceImpl(VenteItemDao dao) {
        super(dao);
    }

}
